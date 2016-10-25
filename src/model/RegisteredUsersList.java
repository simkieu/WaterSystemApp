package model;

//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by simkieu on 10/11/16.
 */
public class RegisteredUsersList {
    private static final RegisteredUsersList instance = new RegisteredUsersList();

    public static RegisteredUsersList getInstance() { return instance; }

    private Map<String, User> databaseUserList = new HashMap<String, User>();

    private RegisteredUsersList() {
        User user1 = new User("Sim Kieu", "simkieu", "hello");
        User user2 = new User("Kyle Bulkley", "kyle", "kyle");
        databaseUserList.put("simkieu", user1);
        databaseUserList.put("kyle", user2);
    }

    public Map<String, User> getRegisteredUsersList() {
        return this.databaseUserList;
    }

    public boolean addUser(User aUser) {
        if (!databaseUserList.containsKey(aUser.getUserName())) {
            databaseUserList.put(aUser.getUserName(), aUser);
            return true;
        }
        return false;
    }
}
