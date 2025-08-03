package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExploreService {
    private List<Destination> historicalPlaces;

    public ExploreService() {
        historicalPlaces = new ArrayList<>();
        historicalPlaces.add(new Destination(
            "Shaniwar Wada",
            "Built in 1736 by Bajirao Peshwa, Mughal-influenced architecture.",
            "Shaniwar Peth, Pune",
            Arrays.asList("Bedekar Misal", "Shabree Veg Thali", "Sujata Mastani")
        ));
    }

    public List<Destination> getHistoricalPlaces() {
        return historicalPlaces;
    }

    public void addReview(String destinationName, String review, double rating) {
        for (Destination d : historicalPlaces) {
            if (d.getName().equalsIgnoreCase(destinationName)) {
                d.addReview(review, rating);
                return;
            }
        }
    }
}
