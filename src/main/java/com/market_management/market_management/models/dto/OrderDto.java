//package com.market_management.market_management.models.dto;
//
//import com.market_management.market_management.models.entities.Local;
//import com.market_management.market_management.models.entities.Order;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class OrderDto {
//    private Long id;
//    private String description;
//    private Double amount;
//    private Local local;
//
//    public OrderDto(Long id, String description, Double amount) {
//    }
//
//    public static OrderDto getOrderDto(Order order){
//        return new OrderDto(order.getId(), order.getDescription(), order.getAmount());
//    }
//
//    public static List<OrderDto> getListOrdersDto(@NotNull List<Order> orders){
//        return orders.stream().map(
//                order -> {
//                    if (order == null) {
//                        throw new IllegalThreadStateException();
//                    }
//                    return new OrderDto(order.getId(), order.getDescription(), order.getAmount());
//                }
//        ).collect(Collectors.toList());
//    }
//}
