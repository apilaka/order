package com.pilaka.order.controller;


import com.pilaka.order.dto.OrderDTO;
import com.pilaka.order.dto.OrderDTOFromFE;
import com.pilaka.order.entity.Order;
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

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        System.out.println("Saving Order from Order Controller");
        OrderDTO orderSavedInDB = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDB, HttpStatus.CREATED);
    }

    @PostMapping("/saveNewOrder")
    public ResponseEntity<Order> saveNewOrder(@RequestBody OrderDTOFromFE orderDetails){
        System.out.println("Saving Order from Order New Controller");
        Order orderSavedInDB = orderService.saveNewOrder(orderDetails);
        return new ResponseEntity<>(orderSavedInDB, HttpStatus.CREATED);
    }

    @GetMapping("/listOrders")
    public List<Order> listOrders(){
        return orderService.listOrders();
    }

}