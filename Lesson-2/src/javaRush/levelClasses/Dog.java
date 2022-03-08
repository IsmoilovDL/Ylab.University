package javaRush.levelClasses;

public class Dog {
    private String name;
    private int age;
    private String color;

    //Создать класс Dog (собака) с тремя инициализаторами:
    //- Имя
    //- Имя, рост
    //- Имя, рост, цвет
    public void initialize(String name){
        this.name=name;
    }
    public void initialize(String name, int age){
        this.name=name;
        this.age=age;

    }
    public void initialize(String name, int age, String color){
        this.name=name;
        this.age=age;
        this.color=color;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(){}

}
