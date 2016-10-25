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

    WaterCondition(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
