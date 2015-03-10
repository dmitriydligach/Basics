package oop;

public class Test {

  public static void main(String[] args) {
    
    Circle aCircle = new Circle("yellow", 5.0);
    aCircle.draw();
    Double circleArea = aCircle.computeArea();
    Double circumference = aCircle.computeCircumference();
    System.out.println("circle area: " + circleArea);
    System.out.println("circumference: " + circumference);
    System.out.println();
    
    Circle anotherCircle = new Circle("green", 1.0);
    anotherCircle.draw();
  }
}
