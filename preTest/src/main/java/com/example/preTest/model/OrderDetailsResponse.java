package com.example.preTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderDetailsResponse {
    List<Order> ordersList;
    List<Shipment> shipmentLists;
}
