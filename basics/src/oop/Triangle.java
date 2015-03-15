package oop;

public class Triangle extends Shape {

  private double sideA;
  private double sideB;
  private double sideC;

  public Triangle(double a, double b, double c) {
    sideA = a;
    sideB = b;
    sideC = c;
  }
  
  public void draw() {
    System.out.println("I am a " + color +  " triangle!");
  }

  /**
   * Implements Heron's formula
   * 
   * s = (a + b + c) / 2
   * area = sqrt(s (s - a) (s - b) (s - c))
   * 
   */
  public double computeArea() {
    double s = (sideA + sideB + sideC) / 2.0;
    return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
  }
}
