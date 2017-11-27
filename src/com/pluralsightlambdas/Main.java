package com.pluralsightlambdas;

public class Main {

    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 5;


        String greeting = "Hello world";
        boolean b = p1.test(greeting);
        System.out.println(greeting + " is longer than 20 chars: " + b);
        Predicate<String> p3 = p1.and(p2);

        System.out.println("P3 for Yes: " + p3.test("Yes"));
        System.out.println("P3 for Good Morning: " + p3.test("Good Morning"));
        System.out.println("P3 for Good Morning Gentlemen: " + p3.test("Good Morning Gentlemen"));

        Predicate<String> p4 = p1.or(p2);
        System.out.println("P4 for Yes: " + p4.test("Yes"));
        System.out.println("P4 for Good Morning: " + p4.test("Good Morning"));
        System.out.println("P4 for Good Morning Gentlemen: " + p4.test("Good Morning Gentlemen"));

        Predicate<String> p5 = Predicate.isEqualTo("Yes");
        System.out.println("P5 for Yes: " + p5.test("Yes"));
        System.out.println("P5 for No: " + p5.test("No"));

        Predicate<Integer> p6 = Predicate.isEqualTo(1);

    }
 }
