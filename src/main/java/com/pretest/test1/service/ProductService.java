package com.pretest.test1.service;

import com.pretest.test1.model.Product;
import com.pretest.test1.model.ProductList;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
    public Integer getProductIdNumber (String productId) {
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
