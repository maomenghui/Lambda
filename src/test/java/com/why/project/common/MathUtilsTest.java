package com.why.project.common;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathUtilsTest extends TestCase {

    @Test
    public void testListLambda() {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        // Lambda ForEach list
        items.forEach(item -> System.out.println(item));

        // Case output D
        items.forEach(s -> {
            if ("D".equals(s)) {
                System.out.println(s);
            }
        });

        // Method reference
        items.forEach(System.out::println);

        // Stream and filter
        items.stream().filter(s -> s.contains("D")).forEach(System.out::println);
    }

    @Test
    public void testMapLambda() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        // Lambda output
        items.forEach((k,v) -> System.out.println(k + " --> " + v));

        // Case output D
        items.forEach((k,v) -> {
            if ("D".equals(k)) {
                System.out.println(k);
            }
        });
    }

    public void test() {

    }

}