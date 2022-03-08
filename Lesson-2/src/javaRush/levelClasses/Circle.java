package javaRush.levelClasses;

public class Circle {
    private  int CenterX;
    private int CenterY;
    private int radius;
    private int width;
    private  String color;

    public void initialize(int CenterX, int CenterY, int radius){
        this.CenterX=CenterX;
        this.CenterY=CenterY;
        this.radius=radius;
    }
    public void initialize(int CenterX, int CenterY, int radius, int width){
        this.CenterX=CenterX;
        this.CenterY=CenterY;
        this.radius=radius;
        this.width=width;
    }
    public void initialize(int CenterX, int CenterY, int radius, int width, String color){
        this.CenterX=CenterX;
        this.CenterY=CenterY;
        this.radius=radius;
        this.width=width;
        this.color=color;
    }
}
