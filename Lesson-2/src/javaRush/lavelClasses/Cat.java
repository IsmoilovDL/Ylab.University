package javaRush.lavelClasses;

public class Cat {
    private String name;
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
