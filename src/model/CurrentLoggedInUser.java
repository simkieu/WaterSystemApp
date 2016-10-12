package model;

/**
 * Created by simkieu on 9/29/16.
 */
public class CurrentLoggedInUser {

    private static final CurrentLoggedInUser instance = new CurrentLoggedInUser();

    public static CurrentLoggedInUser getInstance() { return instance; }

    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }
}
