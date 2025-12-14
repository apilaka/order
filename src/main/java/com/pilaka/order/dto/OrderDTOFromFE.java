package com.pilaka.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "orders")
//@JsonIgnoreProperties(ignoreUnknown = true)

public class OrderDTOFromFE {

    private List<FoodItemsDTO> foodItems;
    private UserDTO userDTO;
    private Restaurant restaurant;

    public List<FoodItemsDTO> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemsDTO> foodItems) {
        this.foodItems = foodItems;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}