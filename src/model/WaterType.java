package model;

/**
 * User: Kyle
 * Date: 10/18/16
 * Time: 6:14 PM
 */
public enum WaterType
{
    Bottled ("Bottled"),
    Well ("Well"),
    Stream ("Stream"),
    Lake ("Lake"),
    Spring ("Spring"),
    Other ("Other");

    private String name;

    WaterType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
