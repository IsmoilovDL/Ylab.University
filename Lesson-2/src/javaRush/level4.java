package javaRush;
import javaRush.levelClasses.Cat;

import java.util.Arrays;
import java.util.Scanner;

public class level4 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat.count++;
        Cat cat2 = new Cat();
        Cat.count++;
        System.out.println("Cats count is " + Cat.count);
        level4 level4=new level4();
        Scanner scanner=new Scanner(System.in);


//        System.out.println("Введите первое число");
//        int a=scanner.nextInt();
//        System.out.println("Введите второе число");
//        int b=scanner.nextInt();
//        level4.findMin(a,b);
//
//        level4.findMax(30,5,8,20);
//
//        level4.sort(2,6,4);
//        level4.equelsName("Boby", "Boby");
//        level4.equelsName("Boby", "Body");
//
//        level4.age(15, "Bob");
//        level4.age2(21, "Bob");

//        level4.while1();

//        level4.while2();
//        level4.for1();
level4.for2(2,4);
    }

    //Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
    public void findMin(int a, int b){
        if (a>b)
            System.out.println("Максимальное число "+a);
        else
            System.out.println("Максимальное число "+b);
    }

    //Ввести с клавиатуры четыре числа, и вывести максимальное из них.
    public void findMax(int a, int b, int c, int d){
        int max=0;
        if(a>max)
            max=a;
        if(b>max)
            max=b;
        if(c>max)
            max=c;
        if (d>max)
            max=d;
        System.out.println(max);
    }

    //Ввести с клавиатуры три числа, и вывести их в порядке убывания.
    public void sort(int a, int b, int c){
        int[] array=new int[3];
        array[0]=a;
        array[1]=b;
        array[2]=c;

        int item;
        for (int i=0; i<array.length; i++){
            if(i>0) {
                item = array[i - 1];
                if (item < array[i]) {
                    array[i - 1] = array[i];
                    array[i] = item;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    //Ввести с клавиатуры два имени, и если имена одинаковые, вывести сообщение «Имена идентичны».
    public void equelsName(String name1, String name2){
        if(name1.equals(name2))
            System.out.println("Имена идентичны");
        else if (name1.length()==name2.length())
            System.out.println("Длины имен равны");
    }

//Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще»
    public void age(int age, String name){
        if(age<18)
            System.out.println("Подрасти еще");
    }
//Ввести с клавиатуры имя и возраст.
//Если возраст больше 20 вывести надпись «И 18-ти достаточно»
    public void age2(int age, String name){
        if(age>20)
            System.out.println("И 18-ти достаточно");
    }


   // Вывести на экран числа от 1 до 10, используя цикл while.
    public void while1(){
        int i=1;
        while (i<=10){
            System.out.println(i);
            i++;
        }
    }

    //Вывести на экран числа от 10 до 1, используя цикл while.
    public void while2(){
        int i=10;
        while(i>=1){
            System.out.println(i);
            i--;
        }
    }

    //Используя цикл for вывести на экран чётные числа от 1 до 100 включительно.
    public void for1(){
        for (int i=1; i<=100; i++){
            if(i%2==0)
                System.out.print(i+" ");
        }
    }

    //Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
    public void for2(int n, int m){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(8);
            }
            System.out.println("");
        }
    }

}
