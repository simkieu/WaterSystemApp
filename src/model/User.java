package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by ngailapdi on 10/12/16.
 */
public class User {
    /**
     * Properties are a way of binding data under the JavaBeans specification.
     *
     * See the article at: http://docs.oracle.com/javafx/2/binding/jfxpub-binding.htm
     * for more details.
     */
    private final StringProperty _name = new SimpleStringProperty();
    private final StringProperty _userID = new SimpleStringProperty();
    private final StringProperty _password = new SimpleStringProperty();
    private final ObjectProperty<AccountType> _accountType = new SimpleObjectProperty();

    /* **********************
     * Getters and setters for properties
     */
    public String getName() { return _name.get(); }
    public void setName(String name) { _name.set(name); }

    public String getUserName() {return _userID.get(); }
    public void setUserName(String userName) { _userID.set(userName); }

    public String getPassword() {return _password.get(); }
    public void setPassword(String password) { _password.set(password); }

    public AccountType getAccountType() { return _accountType.get(); }
    public void setAccountType(AccountType accountType) { _accountType.set(accountType); }
    public ObjectProperty getClassStandingProperty() { return _accountType; }
    /**
     * Make a new student
     * @param name      the user's name
     * @param userID     the user's ID
     * @param password   the user's password
     */
    public User(String name, String userID, String password) {
        this(name, userID, password, AccountType.User);
    }

    public User(String name, String userID, String password, AccountType accountType) {
        _name.set(name);
        _userID.set(userID);
        _password.set(password);
        _accountType.set(accountType);
    }



    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new student dialog
     */
    public User() {

    }

}
