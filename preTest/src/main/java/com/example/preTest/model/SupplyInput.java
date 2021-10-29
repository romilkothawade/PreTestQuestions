package com.example.preTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a Supply input POJO class
 */
@Data
@NoArgsConstructor
public class SupplyInput {
   String productId;
    java.util.Date updateTimeStamp;
    double quantity;
}
