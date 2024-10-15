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
//public class LocalDto {
//    private Long id;
//    private String name;
//    private String floor;
//    private String code;
//    private List<OrderDto> orders;
//
//    public static List<LocalDto> getAllLocalDto(@NotNull List<Local> locals){
//        return locals.stream().map(
//                local -> {
//                    if (local == null) {
//                        throw new IllegalThreadStateException();
//                    }
//                    return new LocalDto(
//                            local.getId(),
//                            local.getName(),
//                            local.getFloor(),
//                            local.getCode(),
//                            local.getOrders()
//                                    .stream()
//                                    .map(
//                                    order -> new OrderDto(order.getId(), order.getDescription(), order.getAmount()))
//                                    .collect(Collectors.toList()));
//                }
//        ).collect(Collectors.toList());
//    }
//}
