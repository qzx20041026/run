package com.qzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class order {
    private Integer orderId;  // 订单唯一标识符
    private Integer customerId;  // 客户ID
    private Integer courierId;  // 配送员ID
    private String pickupAddress;  // 取货地址
    private Integer addressId;  // 宿舍区域ID
    private String deliveryAddress;  // 送货地址
    private String status;  // 订单状态
    private Double totalAmount;  // 订单总金额
    private String description;  // 订单描述
    private LocalDateTime createdAt;  // 订单创建时间
    private LocalDateTime updatedAt;  // 订单更新时间
}
