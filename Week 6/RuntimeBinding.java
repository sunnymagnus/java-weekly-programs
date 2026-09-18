interface Shape {
    void area();
    void display();
}
class Circle implements Shape {
    double radius,result;
    Circle(double radius) {
        this.radius=radius;
    }
    public void area() {
        result=Math.PI*radius*radius;
    }
    public void display() {
        System.out.println("Circle Area: "+result);
    }
}
class Rectangle implements Shape {
    double length,width,result;
    Rectangle(double length,double width) {
        this.length=length;
        this.width=width;
    }
    public void area() {
        result=length*width;
    }
    public void display() {
        System.out.println("Rectangle Area: "+result);
    }
}
class Triangle implements Shape {
    double base,height,result;
    Triangle(double base,double height) {
        this.base=base;
        this.height=height;
    }
    public void area() {
        result=.5*base*height;
    }
    public void display() {
        System.out.println("Triangle Area: "+result);
    }
}
public class RuntimeBinding {
    public static void main(String[] args) {
        Shape s=new Circle(5);
        s.area();
        s.display();
        System.out.println("----------------");
        s=new Rectangle(4,6);
        s.area();
        s.display();
        System.out.println("----------------");
        s=new Triangle(3,8);
        s.area();
        s.display();
    }
}
