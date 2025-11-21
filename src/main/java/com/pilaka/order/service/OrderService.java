package com.pilaka.order.service;

import com.pilaka.order.dto.*;
import com.pilaka.order.entity.Order;
import com.pilaka.order.mapper.OrderMapper;
import com.pilaka.order.repo.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;


    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        System.out.println("Getting user details");
        // createOrder();
        Long newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        System.out.println("User Details: from order service " + userDTO.toString());

//
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        System.out.println("User Details: " + userDTO.toString());
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);

    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
    public Order saveNewOrder(OrderDTOFromFE orderdetails) {

       List< FoodItemsDTO> foodItems = orderdetails.getFoodItemsList();
       Restaurant restaurant = orderdetails.getRestaurant();
       Integer userId = orderdetails.getUserId();
        Long newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderdetails.getUserId());
        Order orderToBeSaved = new Order(newOrderID, foodItems, restaurant, userDTO);
        orderRepo.save(orderToBeSaved);
        return orderToBeSaved;
    }

    public Order createOrder() {

        List<FoodItemsDTO> items = List.of(
                new FoodItemsDTO(1L,
                        "Paneer Butter Masala",
                        "Delicious creamy paneer curry",
                        true,
                        1299L,
                        501,
                        2),
                new FoodItemsDTO(1L,
                        "Paneer Butter Masala",
                        "Delicious creamy paneer curry",
                        true,
                        1299L,
                        501,
                        2)
        );

        Restaurant restaurant = new Restaurant(
                501L,
                "Pilaka Kitchen",
                "123 Newark St, NJ",
                "Glen Allen",
                "Family-friendly Indian restaurant with authentic flavors"
        );

        UserDTO userDTO = new UserDTO(
                101L,
                "ananta",
                "password123",
                "123 Main Street",
                "Newark"
        );
        Long newOrderID = sequenceGenerator.generateNextOrderId();
        Order orderToBeSaved = new Order(newOrderID, items, restaurant, userDTO);
        orderRepo.save(orderToBeSaved);
        return null;

    }


    public List<Order> listOrders() {
     return  orderRepo.findAll();
    }
}