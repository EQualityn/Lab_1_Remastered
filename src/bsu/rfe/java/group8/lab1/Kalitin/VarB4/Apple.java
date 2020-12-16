package bsu.rfe.java.group8.lab1.Kalitin.VarB4;

public class Apple extends Food {

    public Apple(String type) {
// Вызвать конструктор предка, передав ему имя класса
        super("Яблоко");
        this.type = type;
    }

    public void consume() {
        System.out.println(this.name+" "+this.type + " Калорийности " + calculatecalories() + " съедено");
    }

    // Селектор для доступа к полю данных РАЗМЕР
    public String getType() {
        return type;
    }

    // Модификатор для изменения поля данных РАЗМЕР
    public void setSize(String size) {
        this.type = type;
    }

    // Переопределѐнная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return type.equals(((Apple) arg0).type); // Шаг 3
        } else
            return false;
    }

    public int calculatecalories()
    {
        if (type.equals("big"))
        {
            calories=40;
        }else
        if (type.equals("medium"))
        {
            calories=20;
        }else
        if (type.equals("small"))
        {
            calories=10;
        }else return 0;
        return calories;
    }

    // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта, но и его размер
    public String toString() {
        return super.toString() + " размера '" + type.toUpperCase() + "'";
    }
}
