package com.example.preTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This is a Supply output POJO class
 */
@Data
@AllArgsConstructor
public class SupplyOutput {
    String productId;
    java.util.Date updateTimeStamp;
    double quantity;
    String status;
}
