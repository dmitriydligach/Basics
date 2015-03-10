package oop;

public abstract class Shape {

  public String color;
  
  public Shape() {
    color = "white";
  }
  
  public abstract void draw();  
  public abstract double computeArea();
}
