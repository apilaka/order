package com.pilaka.order.service;

import com.pilaka.order.dto.*;
import com.pilaka.order.entity.Order;


import com.pilaka.order.mapper.OrderMapper;
import com.pilaka.order.repo.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SequenceGenerator sequenceGenerator;
;
    @Autowired
    private MongoOperations mongoOperations;


    @Autowired
    private OrderMapper orderMapper ;

    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {

        String newOrderID = String.valueOf(sequenceGenerator.generateNextOrderId());

        Order orderToBeSaved = new Order();
        orderToBeSaved.setOrderId(newOrderID);
        orderToBeSaved.setFoodItems(orderDetails.getFoodItems());

        orderToBeSaved.setRestaurant(orderDetails.getRestaurant());

        orderToBeSaved.setUserDTO(orderDetails.getUserDTO());
        // OR fetch user using userId if required

        Order savedOrder =this.orderMapper.mapOrderDTOFromFEToOrder(orderDetails);
        this.orderRepo.save(savedOrder);
        return this.orderMapper.mapOrderToOrderDTO(savedOrder);
    }

    private UserDTO fetchUserDetailsFromUserId(Long userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
    public List<Order> listOrders() {
     return  orderRepo.findAll();
    }
}