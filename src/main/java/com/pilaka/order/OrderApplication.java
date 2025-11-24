package com.pilaka.order;

import com.pilaka.order.dto.OrderDTO;
import com.pilaka.order.entity.Order;
import com.pilaka.order.mapper.OrderMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.pilaka")
public class OrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
//	@Bean
//	@LoadBalanced
//	public OrderMapper orderMapper(){
//
//        return new OrderMapper() {
//			@Override
//			public Order mapOrderDTOToOrder(OrderDTO orderDTO) {
//				return null;
//			}
//
//			@Override
//			public OrderDTO mapOrderToOrderDTO(Order order) {
//				return null;
//			}
//		};
//    }
}
