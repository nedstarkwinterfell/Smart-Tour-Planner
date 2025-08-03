package main;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        ExploreService exploreService = new ExploreService();

        System.out.println("=============== WELCOME TO TRAVEL & TOURISM PORTAL ===============");
        System.out.println("1. Login\n2. Register\n3. Exit");
        int choice = sc.nextInt();
        sc.nextLine();

        User currentUser = null;
        if (choice == 2) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            if (userDAO.register(new User(username, password, name))) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Username already exists.");
                return;
            }
        } else if (choice == 1) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            currentUser = userDAO.login(username, password);
            if (currentUser == null) {
                System.out.println("Login failed.");
                return;
            }
            System.out.println("Login successful! Welcome, " + currentUser.getName());
        } else {
            return;
        }

        while (true) {
            System.out.println("\nChoose a category to explore:\n1. Historical Places\n2. Exit");
            int exploreChoice = sc.nextInt();
            sc.nextLine();

            if (exploreChoice == 1) {
                List<Destination> list = exploreService.getHistoricalPlaces();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i).getName());
                }
                System.out.print("Enter a choice: ");
                int destChoice = sc.nextInt();
                sc.nextLine();
                Destination d = list.get(destChoice - 1);
                System.out.println("\n******************* " + d.getName() + " *********************");
                System.out.println("INFO: " + d.getInfo());
                System.out.println("ADDRESS: " + d.getAddress());
                System.out.println("FOOD NEARBY: " + String.join(", ", d.getFoodOptions()));
                System.out.println("RATING: " + d.getAverageRating() + "\n");
                for (String r : d.getReviews()) {
                    System.out.println("- " + r);
                }

                System.out.println("\n1. Submit a review\n2. Go back");
                int action = sc.nextInt();
                sc.nextLine();
                if (action == 1) {
                    System.out.print("Enter your rating (1.0 - 5.0): ");
                    double rate = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter your comment: ");
                    String comment = sc.nextLine();
                    exploreService.addReview(d.getName(), comment, rate);
                    System.out.println("Thanks for reviewing!");
                }
            } else {
                break;
            }
        }

        System.out.println("Thank you for exploring with us!");
    }
}
