package oop;

public class Test {

  public static void main(String[] args) {
    
    Circle aCircle = new Circle(5.0);
    aCircle.setColor("green");
    aCircle.draw();
    
    Double circleArea = aCircle.computeArea();
    Double circumference = aCircle.computeCircumference();
    System.out.println("area: " + circleArea);
    System.out.println("circumference: " + circumference);
    System.out.println();
    
    Triangle aTriangle = new Triangle(4.0, 13.0, 15.0);
    aTriangle.draw();
    Double triangleArea = aTriangle.computeArea();
    System.out.println("area: " + triangleArea);
    System.out.println();
    
    Rectangle aRectangle = new Rectangle(100.0, 200.0);
    aRectangle.draw();
  }
}
