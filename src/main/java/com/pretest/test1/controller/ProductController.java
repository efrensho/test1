package com.pretest.test1.controller;

import com.pretest.test1.model.ProductList;
import com.pretest.test1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/sortProducts")
    public ProductList sortProducts(@RequestBody ProductList list) {
        return productService.getSortedProducts(list);
    }
}
