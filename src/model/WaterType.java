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

    /**
     * Constructor
     * @param the name of the water
     */
    WaterType(String name) {
        this.name = name;
    }

    /**
     *
     * @return name of the water in String type
     */
    public String toString() {
        return name;
    }
}
