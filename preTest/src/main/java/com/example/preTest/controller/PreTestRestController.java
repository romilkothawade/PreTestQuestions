package com.example.preTest.controller;

import com.example.preTest.model.*;
import com.example.preTest.service.OrderDetailService;
import com.example.preTest.service.SupplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * This class is responsible for handling the rest calls and divert them to specific point.
 */
@Slf4j
@RestController
public class PreTestRestController {

    @Autowired
    OrderDetailService service;

    @Autowired
    SupplyService supplyService;

    @PostMapping("/getOrderDetails")
    public OrderDetailsResponse getOrderDetails(@RequestBody OrderDetailsInput input){
        try {
            log.info("call for getOrderDetails");
            service.setOrder();
            service.setShipment();
            CompletableFuture<Order> availabilityCompletableFuture=service.getOrders(input.getOrderId());
            CompletableFuture<Shipment> capacityCompletableFuture=service.getShipment(input.getOrderId());
            CompletableFuture.allOf(availabilityCompletableFuture,capacityCompletableFuture);
           // service.getOrderDetailsList(input.getOrderId());
            return null;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @PostMapping("/updateSupply")
    public SupplyOutput getSupplyInfo(@RequestBody SupplyInput input){
        try {
            log.info("call for updateSupply");
           supplyService.setSupplyRecord();
          SupplyOutput output = supplyService.getSupplyStatus(input);
            return output;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }



}
