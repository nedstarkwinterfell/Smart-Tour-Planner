package service;

import model.Destination;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItineraryService {
    private List<Destination> destinations;

    public ItineraryService(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Destination> generateSurpriseItinerary(int count) {
        List<Destination> plan = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count && !destinations.isEmpty(); i++) {
            Destination d = destinations.get(rand.nextInt(destinations.size()));
            if (!plan.contains(d)) plan.add(d);
        }
        return plan;
    }
}
}


