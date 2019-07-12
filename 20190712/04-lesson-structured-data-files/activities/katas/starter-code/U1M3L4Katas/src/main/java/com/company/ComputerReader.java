package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {

        try {
            List<Computer> computers =
                    new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();

            for (Computer comp : computers) {
                System.out.println("=================================");
                System.out.println(comp.getBrand());
                System.out.println(comp.getModel());
                System.out.println(comp.getCpu());
                System.out.println(comp.getRam());
                System.out.println(comp.getStorageSize());

            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }

    }
}
