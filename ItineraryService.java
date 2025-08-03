package service;

import model.User;
import java.util.HashMap;
import java.util.Map;

public class ExpenseTracker {
    private Map<String, Double> expenseMap = new HashMap<>();

    public void addExpense(User user, double amount) {
        expenseMap.put(user.getUsername(), expenseMap.getOrDefault(user.getUsername(), 0.0) + amount);
    }

    public double getTotalExpense(User user) {
        return expenseMap.getOrDefault(user.getUsername(), 0.0);
    }
}
