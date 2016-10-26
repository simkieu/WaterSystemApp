package model;

/**
 * Created by ngailapdi on 10/12/16.
 */
public enum AccountType {
    User ("USER", "US"),
    Worker ("WORKER", "WK"),
    Manager ("MANAGER", "MGR"),
    Admin ("ADMIN", "AD");

    private final String accountTypeName;
    private final String accountTypeCode;

    /**
     * Constructor
     * @param accountTypeName the type of the account
     * @param accountTypeCode the code of the account
     */
    AccountType(String accountTypeName, String accountTypeCode) {
        this.accountTypeName = accountTypeName;
        this.accountTypeCode = accountTypeCode;
    }

    /**
     * Get the name of the account
     * @return account type name
     */
    public String getName() {
        return accountTypeName;
    }

    /**
     * Get the code represent the account type
     * @return the code
     */
    public String getCode() {
        return accountTypeCode;
    }
}
