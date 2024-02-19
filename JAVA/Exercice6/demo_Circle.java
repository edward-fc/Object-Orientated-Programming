
import java.util.Scanner;
class Demo_Circle{
    public static void print_circle(Circle circle){
        System.out.printf("Radius    = %.1f\n",circle.getRadius());
        System.out.printf("Perimeter = %.3f\n",circle.perimeter());
        System.out.printf("Area      = %.3f\n",circle.area());
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double radius = input.nextDouble();
        Circle circle = new Circle(radius);
        print_circle(circle);
    }
}