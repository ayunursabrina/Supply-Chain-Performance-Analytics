import java.util.HashMap;
import java.util.Map;

public class CountryReference {

    private static final Map<String, String> countryMap = new HashMap<>();

    static {

        countryMap.put("Singapore", "Singapore");
        countryMap.put("Tokyo", "Japan");
        countryMap.put("New York", "USA");
        countryMap.put("Los Angeles", "USA");
        countryMap.put("London", "UK");
        countryMap.put("Sydney", "Australia");
        countryMap.put("Dubai", "UAE");
        countryMap.put("Jakarta", "Indonesia");

    }

    public static String getCountry(String city) {
        return countryMap.get(city);
    }
}