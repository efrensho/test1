package com.pretest.test1.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Capacity {
    private String storeNo;
    private String productId;
    private Double availQty;
    private Date date;
}
