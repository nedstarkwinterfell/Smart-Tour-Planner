package service;

import java.util.*;

public class AccommodationService {
    private Map<String, List<String>> accommodationMap;

    public AccommodationService() {
        accommodationMap = new HashMap<>();
        accommodationMap.put("Shaniwar Wada", Arrays.asList("Hotel Shreyas", "The Oakwood Hotel", "Treebo Regency"));
    }

    public List<String> getHotelsNear(String destination) {
        return accommodationMap.getOrDefault(destination, Arrays.asList("No hotels found"));
    }
}