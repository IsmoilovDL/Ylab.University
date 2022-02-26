package javaRush;
import javaRush.levelClasses.rainbow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

//Зачачи уровня 3 част 1
public class level3 {
    public static void main(String[] args) {
        birthDay();
        multiplicate();
        sum();
        wordCombination();
        multipicationTable();
        printRainbowColor();
    }


    //вывод дата рождения используя класс Calendar
    private static void birthDay(){
        Calendar calendar=new GregorianCalendar(1992,Calendar.MAY,21);
        DateFormat df=new SimpleDateFormat("MMM-dd-Y");
        System.out.println("Дата рождения");
        System.out.println(df.format(calendar.getTime()));
    }

    //произведение 10 числе
    private static void multiplicate(){
        int sum=1;
        for (int i=1; i<=10; i++)
        {
            sum=sum*i;
        }
        System.out.println("\nПроизведение число от 1 до 10");
        System.out.println(sum);
    }

    //сумма 10 чисел
    private static void sum(){
        System.out.println("\nВывод суммы чисел от 1 до 10");
        int sum=0;
        for(int i=1; i<=10;i++){
            sum+=i;
            System.out.println(sum);
        }
    }

    //Вывести комбинации слов Мама, Мыла, Раму
    private static void wordCombination(){
        System.out.println("\nВывести комбинации слов Мама, Мыла, Раму");
        String text[] = {"Мама", "Мыла", "Раму"};
        for(int i = 0; i < text.length; i++)
        {
            for (int j = 0; j < text.length; j++)
            {
                for (int k = 0; k < text.length; k++)
                {
                    if (i != j && i != k && j != k)
                    {
                        System.out.println(text[i] + text[j] + text[k]);
                    }
                }
            }
        }
    }

    //Таблица умножение 10 на 10
    private static void multipicationTable(){

        for (int i=1; i<=10; i++){
            for (int j=1; j<=10; j++){
                if(j==10)
                    System.out.print(i*j+"\n");
                else
                    System.out.print(i*j+" ");
            }
        }
    }

    //Создаем 7 объектов класса rainbow и выводым их на экран
    private static void printRainbowColor(){

        rainbow color1=new rainbow();
        color1.setColor("Red");
        rainbow color2=new rainbow();
        color2.setColor("Orange");
        rainbow color3=new rainbow();
        color3.setColor("Yellow");
        rainbow color4=new rainbow();
        color4.setColor("Green");
        rainbow color5=new rainbow();
        color5.setColor("Blue");
        rainbow color6=new rainbow();
        color6.setColor("Indigo");
        rainbow color7=new rainbow();
        color7.setColor("Purple");

        System.out.println("Все цвета радугы");
        System.out.println(color1.getColor());
        System.out.println(color2.getColor());
        System.out.println(color3.getColor());
        System.out.println(color4.getColor());
        System.out.println(color5.getColor());
        System.out.println(color6.getColor());
        System.out.println(color7.getColor());

    }
}
