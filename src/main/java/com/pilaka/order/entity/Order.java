package com.pilaka.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pilaka.order.dto.FoodItemsDTO;
import com.pilaka.order.dto.Restaurant;

import com.pilaka.order.dto.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Order {

    @Transient
    public static final String SEQUENCE_NAME = "sequence";
    @Id
    private String orderId;

    @JsonProperty("foodItems")  // <-- IMPORTANT FIX
    private List<FoodItemsDTO> foodItems;

    private Restaurant restaurant;

    @JsonProperty("userDTO")
    private UserDTO userDTO;  // Better than UserDTO unless you want deep object mapping

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<FoodItemsDTO> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemsDTO> foodItems) {
        this.foodItems = foodItems;
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
