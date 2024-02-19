import java.util.Scanner;
class weight{
    public static double get_weight_kg(){
        
        Scanner input = new Scanner(System.in);
        double weight_kg = input.nextDouble();

        System.out.printf("%.2f",weight_kg);
        return weight_kg;
    }
    public static int convert_kg_imperial(double kg){
        int pound = 0;
        int stone = 0;
        int quarter = 0;
        int hundredweight = 0;

        while (kg > pound) {
            if (kg > 50.80) {
                hundredweight += 1;
                kg -= 50.80;
            }
            else{
                if (kg > 12.70) {
                    quarter += 1;
                    kg -= 12.70;
                }
                else{
                    if (kg > 6.35) {
                        stone += 1;
                        kg -= 6.35;
                    }
                    else{
                        if (kg > 0.45) {
                            pound += 1;
                            kg -= 0.45;
                        }
                    }

                }
            }
        }
        System.out.printf("Equivalent imperial weight is %d hundredweight %d quarter %d stone %d pound",hundredweight,quarter,stone,pound);
        return 0;
    }
    public static void main(String[] args){
        double kg = get_weight_kg();
        convert_kg_imperial(kg);
    }
}