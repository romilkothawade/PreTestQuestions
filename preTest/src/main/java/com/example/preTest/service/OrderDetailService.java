package com.example.preTest.service;

import com.example.preTest.model.Order;
import com.example.preTest.model.OrderDetailsResponse;
import com.example.preTest.model.Shipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderDetailService {
    List<Order> orderList = new ArrayList<>();
    List<Shipment> shipmentList = new ArrayList<>();
    public void setOrder(){
        orderList.add(new Order("Order1","Prod1",2.0));
    }

    public void setShipment(){
        shipmentList.add(new Shipment("Order1","ship1","Prod1", LocalDate.of(2021,02,19),2.0));
    }

    @Async
    public CompletableFuture<Order> getOrders(String orderId){
        try{
            log.info("fetching orders");
            Optional<Order> first = orderList.stream().filter(i -> i.getOrderId().equals(orderId)).findFirst();
            return CompletableFuture.completedFuture(first.get());
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Async
    public CompletableFuture<Shipment> getShipment(String orderId){
        try{
            log.info("fetching Shipment");
            Optional<Shipment> first = shipmentList.stream().filter(i -> i.getOrderId().equals(orderId)).findFirst();
            return CompletableFuture.completedFuture(first.get());
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

   // public OrdeDetailResponse getOrderList(String orderId){
    //   List<Order> orders = orderList.stream().filter(i -> i.getOrderId().equals(orderId)).collect(Collectors.toList());
     //   List shipment = shipmentList.stream().filter(i -> i.getOrderId().equals(orderId)).collect(Collectors.toList());


    //}
}
