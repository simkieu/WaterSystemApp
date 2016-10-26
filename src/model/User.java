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

    /**
     * Get the reporter
     * @return the name of the reporter
     */
    public String getName() { return _name.get(); }

    /**
     * Set the name of the reporter
     * @param name the name of the reporter
     */
    public void setName(String name) { _name.set(name); }

    /**
     * Get the username
     * @return the username
     */
    public String getUserName() {return _userID.get(); }

    /**
     * set the username
     * @param userName the new username to be set
     */
    public void setUserName(String userName) { _userID.set(userName); }

    /**
     * get password
     * @return the password
     */
    public String getPassword() {return _password.get(); }

    /**
     * set new password
     * @param password The new password to be set
     */
    public void setPassword(String password) { _password.set(password); }

    /**
     * get account type
     * @return the account type
     */
    public AccountType getAccountType() { return _accountType.get(); }

    /**
     * set account type
     * @param accountType the type of the account
     */
    public void setAccountType(AccountType accountType) { _accountType.set(accountType); }

    /**
     *
     * @return The account type
     */
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
    /**
     * Make a new student
     * @param name      the user's name
     * @param userID     the user's ID
     * @param password   the user's password
     *@param accountType the type of the account
    */
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
