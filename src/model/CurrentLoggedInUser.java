package model;

/**
 * Created by simkieu on 9/29/16.
 */
public class CurrentLoggedInUser {

    private static final CurrentLoggedInUser instance = new CurrentLoggedInUser();

    public static CurrentLoggedInUser getInstance() { return instance; }

    private User user;

    public User getCurrentUser() {
        return this.user;
    }

    public void setUser(User newUser) {
        this.user = newUser;
    }
}
