package oop;

public class Circle extends Shape {

  private static final double pi = 3.14159226;
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }
  
  public void draw() {
    System.out.println("I am a " + color +  " circle!");
  }

  public double computeArea() {
    return pi * radius * radius;
  }

  public double computeCircumference() {
    return 2 * pi * radius;
  }
}
