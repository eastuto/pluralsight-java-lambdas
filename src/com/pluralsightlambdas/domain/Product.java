package com.pluralsightlambdas.domain;

import java.math.BigDecimal;

public class Product {
    String sku;
    BigDecimal price;
    String description;

    public Product(String sku, String description, BigDecimal price) {
        this.sku = sku;
        this.price = price;
        this.description = description;
    }
}
