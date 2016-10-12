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
    AccountType(String accountTypeName, String accountTypeCode) {
        this.accountTypeName = accountTypeName;
        this.accountTypeCode = accountTypeCode;
    }
    public String getName() {
        return accountTypeName;
    }
    public String getCode() {
        return accountTypeCode;
    }
}
