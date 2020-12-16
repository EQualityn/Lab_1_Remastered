package bsu.rfe.java.group8.lab1.Kalitin.VarB4;

public class Potato extends Food{
    public Potato(String type)
    {
        super("Картофель");
        this.type = type;
    }
    public void consume() {
        System.out.println(this.name+ " " +this.type + " Калорийности " + calculatecalories() + " съедено");
    }
    public String gettype() {
        return type;
    }

    public int calculatecalories()
    {
        if (type.equals("fries"))
        {
            calories=150;
        }else
        if (type.equals("roasted"))
        {
            calories=120;
        }else
        if (type.equals("boiled"))
        {
            calories=700;
        }else return 0;
        return calories;
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0))
        { // Шаг 1
            if (!(arg0 instanceof Potato)) return false; // Шаг 2
            return type.equals(((Potato)arg0).type); // Шаг 3
        }
        else
            return false;
    }

}
