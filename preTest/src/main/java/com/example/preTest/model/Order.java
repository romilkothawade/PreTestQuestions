package com.example.preTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    String orderId;
    String productId;
    Double qty;
}
