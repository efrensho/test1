package com.pretest.test1.service;

import com.pretest.test1.model.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    public ProductList getSortedProducts(ProductList list) {
        Comparator<Product> comparator = Comparator.comparing(product -> getProductIdNumber(product.getProductId()));
        comparator = comparator.thenComparing(Product::getLaunchDate);

        list.setProductList(
                list.getProductList().stream().sorted(comparator.reversed()).collect(Collectors.toList())
        );
        return list;
    }
    public AvailabilityResponse getProductAvailability(AvailabilityRequest request) {
        List<Availability> availabilityList = List.of(
                Availability.builder().storeNo("Store001").productId("Prod1").date(new Date(2021- 2 -19)).noOfOrdersAccepted(1.0).build(),
                Availability.builder().storeNo("Store001").productId("Prod1").date(new Date(2021- 2 -20)).noOfOrdersAccepted(3.0).build(),
                Availability.builder().storeNo("Store001").productId("Prod1").date(new Date(2021- 2 -21)).noOfOrdersAccepted((double) 0).build()
        );

        List<Capacity> capacityList = List.of(
                Capacity.builder().storeNo("Store001").productId("Prod1").date(new Date(2021- 2 -19)).availQty((double) 0).build(),
                Capacity.builder().storeNo("Store001").productId("Prod1").date(new Date(2021- 2 -20)).availQty(2.0).build(),
                Capacity.builder().storeNo("Store001").productId("Prod1").date(new Date(2021- 2 -21)).availQty(2.0).build()
        );

        return AvailabilityResponse.builder()
                .storeNo(request.getStoreNo())
                .productId(request.getProductId())
                .reqQty(request.getReqQty())
                .reqDate(request.getReqDate())
                .status("Available")
                .build();
    };

    protected Integer getProductIdNumber (String productId) {
        char[] chars = productId.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        return Integer.valueOf(sb.toString().trim());
    }
}
