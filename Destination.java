package model; 
import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private String info;
    private String address;
    private List<String> foodOptions;
    private List<String> reviews;
    private double rating;
    private int ratingCount;

    public Destination(String name, String info, String address, List<String> foodOptions) {
        this.name = name;
        this.info = info;
        this.address = address;
        this.foodOptions = foodOptions;
        this.reviews = new ArrayList<>();
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    public void addReview(String review, double rating) {
        this.reviews.add(review);
        this.rating += rating;
        this.ratingCount++;
    }

    public double getAverageRating() {
        return ratingCount == 0 ? 0 : rating / ratingCount;
    }

    // Getters
    public String getName() { return name; }
    public List<String> getFoodOptions() { return foodOptions; }
    public List<String> getReviews() { return reviews; }
    public String getInfo() { return info; }
    public String getAddress() { return address; }
}
