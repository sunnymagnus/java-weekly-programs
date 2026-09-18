interface Shape {void area();void display();}
class Circle implements Shape {double radius,result;Circle(double radius){this.radius=radius;}public void area(){result=Math.PI*radius*radius;}public void display(){System.out.println("Circle Area: "+result);}}
class Rectangle implements Shape {double length,width,result;Rectangle(double length,double width){this.length=length;this.width=width;}public void area(){result=length*width;}public void display(){System.out.println("Rectangle Area: "+result);}}
class Triangle implements Shape {double base,height,result;Triangle(double base,double height){this.base=base;this.height=height;}public void area(){result=.5*base*height;}public void display(){System.out.println("Triangle Area: "+result);}}
public class RuntimeBinding {public static void main(String[] args){Shape[] shapes={new Circle(5),new Rectangle(4,6),new Triangle(3,8)};for(Shape shape:shapes){shape.area();shape.display();System.out.println("----------------");}}}
