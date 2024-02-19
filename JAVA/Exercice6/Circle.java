import java.lang.Math;

class Circle{
    private double radius;
   
    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
    public double area(){
        return Math.PI*radius*radius;
    }
    public double perimeter(){
        return 2*radius*Math.PI;
    }
}