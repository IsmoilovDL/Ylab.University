package javaRush.levelClasses;
//Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
//- Имя
//- Имя, возраст
//- Имя, возраст, пол
public class Friend {

    private String name;
    private int age;
    private String gender;
    public void initialize(String name){
        this.name=name;
    }

    public void initialize(String name, int age){
        this.name=name;
        this.age=age;
    }

    public void initialize(String name, int age, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
}
