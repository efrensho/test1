package com.pretest.test1.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Availability {
    private String storeNo;
    private String productId;
    private Double noOfOrdersAccepted;
    private Date date;
}
