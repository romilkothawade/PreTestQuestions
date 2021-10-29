package com.example.preTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Slf4j
public class Shipment {
    String orderId;
    String shipmentId;
    String productId;
    LocalDate shipmentDate;
    Double qty;
}
