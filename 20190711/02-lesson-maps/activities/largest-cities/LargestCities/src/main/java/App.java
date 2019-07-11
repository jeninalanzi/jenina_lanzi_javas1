import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        // Create variables to hold data
        City ny = new City("New York", 8654321);
        City la = new City("Los Angeles", 4563218);
        City chi = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desmoines = new City("Des Moines", 217521);
        City atl = new City ("Atlanta", 486213);

        // Create Map - key: String state, value: City
        Map<String, City> citiesMap = new HashMap<>();

        // Push these new City objects into your new HashMap.
        citiesMap.put("NY", ny);
        citiesMap.put("CA", la);
        citiesMap.put("IL", chi);
        citiesMap.put("CO", denver);
        citiesMap.put("IA", desmoines);
        citiesMap.put("GA", atl);

        // Print key and values to user. Including the state
        Set<Map.Entry<String, City>> allEntries = citiesMap.entrySet();

        // IMPORTANT!! getValue().getName() accesses the Object getter!!!
        for (Map.Entry<String, City> entry : allEntries) {
            System.out.println("State: " + entry.getKey() + " | City: " + entry.getValue().getName() + " | Population: " + entry.getValue().getPopulation());
        }


    }
}
