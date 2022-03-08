package javaRush.levelClasses;

public class Cat {
    private String name;
    private int age;
    private int weight;
    private int strenght;

    public Cat(){

    }
    public Cat(String name, int age, int weight, int strenght){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.strenght=strenght;
    }

    public boolean fight(Cat opponentCat){
        if(this.age<opponentCat.age && this.weight>opponentCat.weight || this.strenght> opponentCat.strenght)
            return true;
        else
            return false;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    private static int catsCount = 0;
    public static void addNewCat()
    {
        catsCount++;
    }

    public static void setCatsCount(int catsCount)
    {
        Cat.catsCount=catsCount;
    }

    private String fullName;
    public void setName(String firstName, String lastName)
    {
        String fullName = firstName + lastName;
        this.fullName=fullName;
    }

    public static int count=0;

 
}
