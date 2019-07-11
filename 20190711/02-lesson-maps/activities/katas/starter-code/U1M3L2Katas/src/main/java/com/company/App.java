package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> map) {
        // Iterate through and prints out all the KEYS in the map.
        Set<String> mapKeys = map.keySet();
        for (String key : mapKeys) {
            System.out.println(key);
        }
    }

    public void printValues(Map<String, String> map) {
        // Iterate through and prints out all the VALUES in the map.
        Collection<String> mapValues = map.values();
        for (String value : mapValues) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(Map<String, String> map) {
        // Iterate through the Entry Set of Map and print both KEYS and VALUES
        // as format: [ key: value ]
        Set<Map.Entry<String, String>> allEntries = map.entrySet();
        for (Map.Entry<String, String> entry : allEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, Integer> mapFun(Map<String, Integer> carMap) {
        // Declare what carMap actually is.
        // Also instantiate a new Map to return.
        carMap = new HashMap<>();
        Map<String, Integer> mapToReturn = new HashMap<>();

        // 4.3 Map should always have these entries:
        carMap.put("Toyota Camry", 2012);
        carMap.put("Chevy Camaro", 1969);
        carMap.put("Hyundai Genesis", 2015);
        carMap.put("Jeep Wrangler", 2003);
        carMap.put("Honda Civic", 2018);
        carMap.put("Toyota Supra", 1995);
        carMap.put("Pontiac GTO", 1964);


        carMap.putAll(mapToReturn);

        // 4.4 add 2 NEW entries to new map (see for entries)
        mapToReturn.putIfAbsent("Ford Explorer", 2012);
        mapToReturn.putIfAbsent("Smart Fortwo", 2013);


        // 4.5 Remove Jeep Wrangler
        carMap.remove("Jeep Wrangler", 2012);

        // Copy these elements to new Map.
        mapToReturn.putAll(carMap);



        return mapToReturn;
    }

    // 5. listCars
    // read the directions carefully for number 5 and check the hint too.
        // 1. toyotaList
        // 2. Create a List called fordList to hold all the Car variables
        // with "Ford" as the make and add them to the List.

        // 3. Create a List called hondaList to hold all the Car variables
        // with "Honda" as the make and add them to the List.

        // 4. Store all 3 List in a Map with the make as the key.

        // Return map

    public Map<String, List<Car>> listCars(List<Car> carObjects) {
        carObjects = new ArrayList<>();

        Car car = new Car(null, null);

        ArrayList<Car> toyotaList = new ArrayList<>();
        ArrayList<Car> fordList = new ArrayList<>();
        ArrayList<Car> hondaList = new ArrayList<>();

        for (int i = 0; i < carObjects.size(); i++) {
            if (car.getMake().equals("Toyota")) {
                toyotaList.add(carObjects.get(i));
            } else if (car.getMake().equals("Ford")) {
                fordList.add(carObjects.get(i));
            } else if (car.getMake().equals("Honda")) {
                hondaList.add(carObjects.get(i));
            }
        }

        Map<String, List<Car>> carMap = new HashMap<>();
        carMap.put("Toyota", toyotaList);
        carMap.put("Ford", fordList);
        carMap.put("Honda", hondaList);

        return carMap;
    }
}
