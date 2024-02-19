import java.util.Scanner;
class weight{
    public static double get_weight_kg(){
        System.out.println("Enter kg:");
        Scanner input = new Scanner(System.in);
        double weight_kg = input.nextDouble();
        return weight_kg;
    }
    public static int convert_kg_imperial(double kg){
        double stone = 0;
        double pound = 0;
        double oz = 35.274 * kg;
        if (oz>=16){
            pound = (oz-oz % 16)/16;
            oz = oz % 16;
        }
        if (pound>=14){
            stone = (pound-pound % 16)/16;
            pound = pound % 16;
        }
        System.out.printf("Equivalent imperial weight is %f stone %f pound %.2f oz/n",stone,pound,oz);
        return 0;
    }
    public static void main(String[] args){
        double kg = get_weight_kg();
        convert_kg_imperial(kg);
    }
}