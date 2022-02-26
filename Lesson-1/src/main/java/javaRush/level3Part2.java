package javaRush;

import java.util.Scanner;

public class level3Part2 {
    public static void main(String[] args) {
        captureTheWord();
        salary();
        prueLove();
    }

    //Вася захватит мир через 8 лет. Му-ха-ха!
    private static void captureTheWord(){
        Scanner input =new Scanner(System.in);
        System.out.println("Введите имю");
        String name=input.nextLine();
        System.out.println("Введите лет");
        String year=input.nextLine();

        System.out.println(name+" захватит мир через "+year+" лет. Му-ха-ха!");
    }

    private static void salary(){
        Scanner input =new Scanner(System.in);
        System.out.println("Введите имю");
        String name=input.nextLine();
        System.out.println("Введите сумму");
        String sum=input.nextLine();
        System.out.println("Введите количество лет");
        String year=input.nextLine();
        System.out.println(name+" получает "+sum+" через "+year+" лет.");
    }

    private static void prueLove(){
        Scanner input=new Scanner(System.in);
        System.out.println("Введите имю 1");
        String name1=input.nextLine();
        System.out.println("Введите имю 2");
        String name2=input.nextLine();
        System.out.println("Введите имю 3");
        String name3=input.nextLine();

        System.out.println(name1+" + "+name2+" + "+name3+" = Чистая любовь, да-да!");

    }
}
