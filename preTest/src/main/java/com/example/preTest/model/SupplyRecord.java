package com.example.preTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplyRecord {
    String productId;
    java.util.Date updateTimeStamp;
    Double quantity;
}
