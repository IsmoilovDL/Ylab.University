package javaRush;

import javaRush.levelClasses.Cat;

public class level5 {
    public static void main(String[] args) {

        //Реализовать метод boolean fight(Cat anotherCat): реализовать механизм драки котов в зависимости
        // от их веса, возраста и силы. Зависимость придумать самому. Метод должен определять,
        // выиграли ли мы (this) бой или нет,
        // т.е. возвращать true, если выиграли и false - если нет.
        Cat cat1=new Cat("Murka", 5, 10, 20);
        Cat cat2=new Cat("Tom", 4, 9, 15);
        boolean fightResult=cat1.fight(cat2);
        System.out.println(fightResult);
    }
}
