package model;

/**
 * User: Kyle
 * Date: 10/18/16
 * Time: 6:20 PM
 */
public enum WaterCondition
{
    Waste ("Waste"),
    Treatable_Clear ("Treatable (Clear)"),
    Treatable_Muddy ("Treatable (Muddy)"),
    Potable ("Potable");

    private String name;

    /**
     * Constructor
     * @param the condition of the water
     */
    WaterCondition(String name) {
        this.name = name;
    }

    /**
     *
     * @return condition of the water in String type
     */
    public String toString() {
        return name;
    }
}
