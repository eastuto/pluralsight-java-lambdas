package com.pluralsightlambdas.data;

import com.pluralsightlambdas.domain.Product;
import com.pluralsightlambdas.domain.Promotion;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class SampleData {
    public static final Product appleTV = new Product("atv", "Apple TV", new BigDecimal(109.50));
    public static final Product iPad = new Product("ipd", "Super iPad", new BigDecimal(549.99));
    public static final Product macbookPro = new Product("mbp", "Macbook Pro", new BigDecimal(1399.99));



//    pricingStrategy.computeIfAbsent(Promotion.THREE_FOR_TWO, promotion -> new ArrayList<>()).add(appleTV);
//    pricingStrategy.computeIfAbsent(Promotion.BULK_DISCOUNT, promotion -> new ArrayList<>()).add(iPad);
//    pricingStrategy.computeIfAbsent(Promotion.FREE_VGA_ADAPTER, promotion -> new ArrayList<>()).add(macbookPro);

    public static Stream<Product> getProductsStream() {
        return Stream.of(appleTV, iPad, macbookPro);
    }

    public static List<Product> getProducts() {
        return Arrays.asList(appleTV, iPad, macbookPro);
    }

    public static Map getPricingRules() {
        Map<Promotion, List<Product>> pricingRules = new HashMap<>();
        pricingRules.computeIfAbsent(Promotion.THREE_FOR_TWO, promotion -> new ArrayList<>()).add(appleTV);
        pricingRules.computeIfAbsent(Promotion.BULK_DISCOUNT, promotion -> new ArrayList<>()).add(iPad);
        pricingRules.computeIfAbsent(Promotion.FREE_VGA_ADAPTER, promotion -> new ArrayList<>()).add(macbookPro);
        return pricingRules;
    }


}
