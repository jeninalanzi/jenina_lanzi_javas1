package com.company;

import com.company.model.Television;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

//        No tests provided for this lesson.
//        Using the data provided in televisions.json, complete the following. Use lambdas and streams for all of these where appropriate.
//
//
//                Read the data from the .json and store it as a List.
//                Find all televisions with a screen size greater than 60 inches. Use the .forEach method to print out all entries.
//                Group all televisions into a Map by brand. Print out the list of brands.
//        Find and display the average screenSize.
//        Find and display the largest screen.
//
//
//
//        Challenge
//
//
//        Sort the data by screen size, then print out the sorted list.

        // 1. Read the JSON file and store into List.
        try {
            // Initiate json read sequence
            ObjectMapper mapper = new ObjectMapper();

            List<Television> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

//            for (Television tv : tvList) {
//                System.out.println("================================");
//                System.out.println(tv.getBrand());
//                System.out.println(tv.getModel());
//                System.out.println(tv.getPrice());
//                System.out.println(tv.getScreenSize());
//            }

            // Print out info for all tv's with a screenSize GREATER than 60.
            int size = 60;

            tvList
                .stream()
                    .filter(tv -> tv.getScreenSize() > size)
                    .forEach(tv -> {
                        System.out.println("--------------------------");
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Price: $" + tv.getPrice());
                        System.out.println("Screen Size: " + tv.getScreenSize() + "in.");
                    });

            // Divider
            System.out.println("=======================================\n");

            // Group all tvs by Brand into a Map
            Map<String, List<Television>> tvsByBrand =
                    tvList
                        .stream()
                        .collect(Collectors.groupingBy(tv -> tv.getBrand()));

            Set<String> keys = tvsByBrand.keySet();
            for (String key : keys) {
                System.out.println(key);
            }

            // Divider
            System.out.println("=======================================\n");

            // Print out average size of tvs.
            double averageTvSize =
                    tvList
                    .stream()
                    .mapToInt(tv -> tv.getScreenSize())
                    .average()
                    .getAsDouble();

            System.out.println("Average screen size is: " + averageTvSize + " in\n");

            // Divider
            System.out.println("=======================================\n");

            // Display largest screen size.
            int largestScreen =
                    tvList
                    .stream()
                    .mapToInt(tv -> tv.getScreenSize())
                    .max()
                    .getAsInt();

            System.out.println("The largest screen size is " + largestScreen + " in.");


            // Divider
            System.out.println("=======================================\n");


        } catch(IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }
}
