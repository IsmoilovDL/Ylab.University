package javaRush;
//Задачи уровня 1
public class level1 {
    public static void main(String[] args) {
       level1 l1=new level1();
       l1.task1();
       l1.task2();

    }

    private void task1(){
        print("\nМеня зовут Амиго.\n");
        for (int i=1;i<=5; i++)
            print("Я согласен на зарплату $"+10*i+"/месяц в первый год.");
        print("\nСпасибо за щедрость, друг Риша!");
    }

    private void task2(){
        String[] strings= {"800", "1500", "2200", "2700", "3200"};
        print("Меня зовут Амиго.\n");
        for (String item:strings) {
            print("Я согласен на зарплату $"+item+"/месяц в первый год.");
        }
        print("\nПоцелуй мой блестящий металлический зад!");
    }
    private static void print(String inputLine){
        System.out.println(inputLine);
    }
}
