package bsu.rfe.java.group8.lab1.Kalitin.VarB4;
import java.lang.reflect.Constructor;
import java.util.*;
@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food [20];
        int items=0;
        int fries=0;
        int roasted=0;
        int boiled=0;
        int numcalories=0;
        int big=0;
        int medium=0;
        int small =0;
        int cheese=0;
        for (String arg :args)
        {
            String[] parts = arg.split("/");
            if (parts[0].equals("potato") || parts[0].equals("Potato")){
                if (parts[1].equals("fries")){
                    breakfast[items]=new Potato(parts[1]);
                    fries++;
                }
                if (parts[1].equals("roasted")){
                    breakfast[items]=new Potato(parts[1]);
                    roasted++;
                }
                if (parts[1].equals("boiled")){
                    breakfast[items]=new Potato(parts[1]);
                    boiled++;
                }
            }

            if (parts[0].equals("Apple") || parts[0].equals("apple")){
                if (parts[1].equals("big")){
                    breakfast[items]=new Apple(parts[1]);
                    big++;
                }
                if (parts[1].equals("medium")){
                    breakfast[items]=new Apple(parts[1]);
                    medium++;
                }
                if (parts[1].equals("small")){
                    breakfast[items]=new Apple(parts[1]);
                    small++;
                }
            }
            if (parts[0].equals("cheese") || parts[0].equals("Cheese"))
            {
                breakfast[items]=new Cheese(parts[0]);
                cheese++;
            }
            items++;
        }
        //Arrays.sort(breakfast, new FoodComparator());
        for (Food item : breakfast)
            if (item!=null) {
                // System.out.println("TROUBLESHOOTING");
                item.consume();
            }

        for (String arg : args)
            if (arg.startsWith("-"))
            {
                if (arg.equals("-calories"))
                {
                    for (Food item : breakfast) {
                        if (item != null)
                            numcalories += item.calculatecalories();
                    }
                    System.out.println("Calories in your breakfast: " +numcalories);
                }
                else if (arg.equals("-sort")){                //случай "ClassNotFoundException", когда мы задаем параметр -sort
                    Arrays.sort(breakfast, new Comparator() {
                        public int compare(Object o1, Object o2)
                        {
                            if (o1 == null || o2==null)
                            {
                                return 0;
                            }
                            if (((Food) o1).type==null)
                                return 0;
                            if (((Food)o1).type.charAt(0)> ((Food)o2).type.charAt(0)) {

                                return 1;
                            }
                            if (((Food)o1).type.charAt(0) < ((Food)o2).type.charAt(0)) {

                                return -1;
                            }
                            else return 0;
                        }
                    });}
                else break;
            }
        System.out.println("Завтрак (отсортированный вариант):");
        for (Food item : breakfast)
        {
            if (item != null)
            {
                if (item.calculatecalories()==0)
                    continue;
                item.consume();
                //System.out.println(" " + item.calculatecalories());
            }

        }
        // System.out.println(breakfast);
        System.out.println("Съедено:");
        System.out.println("Картофеля фри " + fries + " порций. "+ "Жареного картофеля " + roasted + " порций. "+ "Вареного картофеля " + boiled + " порций.");
    }
}