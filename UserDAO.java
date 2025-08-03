
package dao;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<String, User> users = new HashMap<>();

    public boolean register(User user) {
        if (users.containsKey(user.getUsername())) return false;
        users.put(user.getUsername(), user);
        return true;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password) ? user : null;
    }
}
