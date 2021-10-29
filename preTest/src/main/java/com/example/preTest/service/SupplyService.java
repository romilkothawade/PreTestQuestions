package com.example.preTest.service;

import com.example.preTest.model.SupplyInput;
import com.example.preTest.model.SupplyOutput;
import com.example.preTest.model.SupplyRecord;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is resposible for providing the service for supply operations.
 */
@Slf4j
@Service
public class SupplyService {

    List<SupplyRecord> recordList = new ArrayList<>();

    public void setSupplyRecord() {

        recordList.add(new SupplyRecord("Product1",  new Date("2021-03-16T08:53:48.616Z"), 10.0));
        recordList.add(new SupplyRecord("Product2",  new Date("2021-03-16T08:59:48.616Z"), 5.0));
        recordList.add(new SupplyRecord("Product3",  new Date("2021-03-16T09:10:48.616Z"), 30.0));
        recordList.add(new SupplyRecord("Product4", new Date("2021-03-16T09:10:48.616Z"), 20.0));
    }

    public SupplyOutput getSupplyStatus(SupplyInput input) {
        try {
            double sum = 0;
            String status;
            double quantity = input.getQuantity();
            sum = recordList.stream().filter(i -> i.getProductId().equals(input.getProductId())
                    && i.getUpdateTimeStamp().before(input.getUpdateTimeStamp())).mapToDouble(i -> i.getQuantity()).sum();
            if (sum > 0) {
                status = "out of";
            } else {
                status = "Updated";
               quantity= quantity+sum;
            }
            SupplyOutput output = new SupplyOutput(input.getProductId(), input.getUpdateTimeStamp(), quantity, status);
            return output;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}
