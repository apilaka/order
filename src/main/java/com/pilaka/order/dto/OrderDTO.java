package com.pilaka.order.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
//
//
//@Setter
//@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "order")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    private Long orderId;
    private List<FoodItemsDTO> foodItems;
    private Restaurant restaurant;
    private UserDTO userDTO;

    public Object getStatus() {
        return "True";
    }

    public List<FoodItemsDTO> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemsDTO> foodItems) {
        this.foodItems = foodItems;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}