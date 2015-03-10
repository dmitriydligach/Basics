package oop;

public class Circle extends Shape {

  public static final double pi = 3.14159226;
  public double radius;

  public Circle(String color, double radius) {
    this.color = color;
    this.radius = radius;
  }
  
  @Override
  public void draw() {
    System.out.println("I am a " + color +  " circle!");
  }

  @Override
  public double computeArea() {
    return pi * radius * radius;
  }

  public double computeCircumference() {
    return 2 * pi * radius;
  }
}
