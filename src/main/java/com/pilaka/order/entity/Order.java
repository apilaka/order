package com.pilaka.order.entity;
import com.pilaka.order.dto.FoodItemsDTO;
import com.pilaka.order.dto.Restaurant;
import com.pilaka.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private Long orderId;
    private List<FoodItemsDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;

}