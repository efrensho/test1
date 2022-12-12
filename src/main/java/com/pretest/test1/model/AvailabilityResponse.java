package com.pretest.test1.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AvailabilityResponse {
    private String storeNo;
    private String productId;
    private Double reqQty;
    private Date reqDate;
    private String status;
}
