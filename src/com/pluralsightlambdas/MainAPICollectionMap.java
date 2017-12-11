package com.pluralsightlambdas;

import com.pluralsightlambdas.data.SampleData;
import com.pluralsightlambdas.domain.Product;
import com.pluralsightlambdas.domain.Promotion;

import java.math.BigDecimal;
import java.util.*;

public class MainAPICollectionMap {
    public static void main(String... args) {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Francisco", 18);

        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));

        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City paris = new City("Paris");

        Map<City, List<Person>> map = new HashMap<>();
        map.putIfAbsent(paris, new ArrayList<>());
        map.get(paris).add(p1);

        // can do this in one line as this method returns the value
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        // now since newYork exists the lambda expression will not be executed
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

//        System.out.println("People from Paris: " + map.get(paris)); // returns null if paris does not exist
        System.out.println("People from Paris: " + map.getOrDefault(paris, Collections.EMPTY_LIST));
        System.out.println("People from New York: " + map.getOrDefault(newYork, Collections.EMPTY_LIST));

        // Merge method

        Map<City, List<Person>> map1 = new HashMap<>();
        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

        System.out.println("Map 1");
        map1.forEach((city, peeps) -> System.out.println(city + " : " + peeps));

        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);

        System.out.println("Map 2");
        map2.forEach((city, peeps) -> System.out.println(city + " : " + peeps));

        // Loop through all the key value pairs in map 2 and add them to map 1 using merge() one at a time
        // we add the key value pair from map2 to map1 by using the merge() call

        map2.forEach(
                (city, peeps) -> {
                    // pass the city key and peeps list from map 2 into the map1 merge function
                    // if the key is not present in map1, work is done and the key value pair gets added to map1
                    // If it's already in map1 then binary operator will merge the value from map1 and the new value from map2
                    map1.merge(
                            city, peeps,
                            (peepsFromMap1, peepsFromMap2) -> {
                                peepsFromMap1.addAll(peepsFromMap2);
                                return peepsFromMap1;
                            });
                }
        );

        // Print the result in map1
        System.out.println("Map 1");
        map1.forEach((city, peeps) -> System.out.println(city + " : " + peeps));

        // Dius
        Map<Promotion, List<Product>> pricingStrategy = SampleData.getPricingRules();

        Product appleTV = new Product("atv", "Apple TV", new BigDecimal(109.50));
        Product iPad = new Product("ipd", "Super iPad", new BigDecimal(549.99));
        Product macbookPro = new Product("mbp", "Macbook Pro", new BigDecimal(1399.99));
        pricingStrategy.computeIfAbsent(Promotion.THREE_FOR_TWO, promotion -> new ArrayList<>()).add(appleTV);
        pricingStrategy.computeIfAbsent(Promotion.BULK_DISCOUNT, promotion -> new ArrayList<>()).add(iPad);
        pricingStrategy.computeIfAbsent(Promotion.FREE_VGA_ADAPTER, promotion -> new ArrayList<>()).add(macbookPro);

    }
}
