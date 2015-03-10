package oop;

public class Rectangle extends Shape {

  public double height;
  public double length;

  public Rectangle(double height, double length) {
    this.height = height;
    this.length = length;
  }
  
  public void draw() {
    System.out.println("I am a " + color +  " rectangle!");
  }

  public double computeArea() {
    return height * length;
  }
}
