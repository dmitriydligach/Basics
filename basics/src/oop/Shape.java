package oop;

public abstract class Shape {

  protected String color;
  
  public Shape() {
    color = "white";
  }
  
  public void setColor(String color) {
    this.color = color;
  }
  
  public abstract void draw();
  
  public abstract double computeArea();
}
