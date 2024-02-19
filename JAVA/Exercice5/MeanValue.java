class MeanValue{
    public static double meanValue(String[] data){
        double sum = 0;
        int total = 0;
        for (int i = 0; i < data.length;i++){
            double value = Double.parseDouble(data[i]);
            sum += value;
            total = i+1;
        }
        sum /= total;
        return sum;
    }
    public static void main(String[] args){
        if (args.length == 0){
            System.err.println("Usage: java MeanValue <values...>");
            System.exit(0);
        }
        double mean = meanValue(args);
        System.out.printf("%.3f",mean);
    }
}