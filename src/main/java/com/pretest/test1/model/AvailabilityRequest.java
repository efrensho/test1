package com.pretest.test1.model;

import lombok.Data;

import java.util.Date;

@Data
public class AvailabilityRequest {
    private String storeNo;
    private String productId;
    private Double reqQty;
    private Date reqDate;
}
