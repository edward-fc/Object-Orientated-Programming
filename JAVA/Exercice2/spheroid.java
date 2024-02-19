import java.util.Scanner;
import java.lang.Math;

class Spheroid{
    private static double calulate_eccentricity(double equa_radius, double polar_radius){
        double result;
        result = Math.sqrt(1-(polar_radius*polar_radius)/(equa_radius*equa_radius));
        System.out.printf("Eccentricity = %.3f \n",result);
        return result;
    }
    private static double calulate_volume(double equa_radius, double polar_radius){
        double result;
        result = (4*Math.PI*(equa_radius*equa_radius)*polar_radius)/3;
        int power_10 = 0;
        while (result > 10) {
            result /= 10;
            power_10 += 1;
        }
        System.out.printf("Volume = %.5fe+%d cubic km\n",result,power_10);
        return result;
    }
    public static void main(String arg[]){
        System.out.println("Enter equatorial radius in km: ");
        Scanner input = new Scanner(System.in);
        double equa_radius = input.nextDouble();
        System.out.println("Enter polar radius in km: ");
        Scanner input2 = new Scanner(System.in);
        double polar_radius = input2.nextDouble();
        calulate_eccentricity(equa_radius, polar_radius);
        calulate_volume(equa_radius, polar_radius);
    }
}