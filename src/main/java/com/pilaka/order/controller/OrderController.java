package com.pilaka.order.controller;

import com.pilaka.order.dto.OrderDTO;
import com.pilaka.order.dto.OrderDTOFromFE;
import com.pilaka.order.entity.Order;
//import com.pilaka.order.mapper.OrderMapper;
import com.pilaka.order.repo.OrderRepo;
import com.pilaka.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;
//
//    @Autowired
//    OrderMapper orderMapper;

    @Autowired
    OrderRepo orderRepo;

    @PostMapping(value="/saveOrder" , produces = "application/json")
    public ResponseEntity<Order> saveOrder(@RequestBody Order orderDetails){
        System.out.println("Saving Order from Order Controller");
    this.orderRepo.save(orderDetails);
        return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
    }
    @PostMapping( value="/saveNewOrder" , produces = "application/json" )
    public ResponseEntity<OrderDTOFromFE> saveNewOrder(@RequestBody OrderDTOFromFE orderDetails){
        System.out.println("Saving Order from Order New Controller");
        this.orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
    }
    @GetMapping("/listOrders")
    public List<Order> listOrders(){
        return orderService.listOrders();
    }


    @PostMapping(value="/createOrder" , produces = "application/json")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO orderSavedInDB = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDB, HttpStatus.CREATED);
    }

}