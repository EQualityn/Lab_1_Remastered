package bsu.rfe.java.group8.lab1.Kalitin.VarB4;

public abstract class Food implements Consumable, Nutritious{
    String name = null;
    int calories = 0;
    String type=null;

    public Food(String name)
    {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public boolean equals(Object arg0)
    {
        if (!(arg0 instanceof Food))
            return false;
        if (name == null || ((Food)arg0).name==null)
            return false;
        return name.equals(((Food)arg0).name);
    }
}
