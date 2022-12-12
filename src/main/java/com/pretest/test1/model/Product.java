package com.pretest.test1.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Product {
    private String productId;
    private String productName;
    private String unitOfMeasure;
    private Date launchDate;
}
