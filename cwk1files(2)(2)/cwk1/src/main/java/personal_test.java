import java.time.ZonedDateTime;
import java.io.IOException;

class Demo_test {
    private static ZonedDateTime t1, t2, t3, t4;
    private static Point p1, p2, p3, p4;
    private static Track track1, track2;

    public static void perTestSetup() {
        t1 = ZonedDateTime.parse("2022-02-17T09:52:39Z");
        t2 = ZonedDateTime.parse("2022-02-17T09:53:31Z");
        t3 = ZonedDateTime.parse("2022-02-17T09:54:29Z");
        t4 = ZonedDateTime.parse("2022-02-17T09:55:31Z");

        p1 = new Point(t1, -1.547720, 53.803941, 69.8);
        p2 = new Point(t2, -1.548531, 53.804616, 72.5);
        p3 = new Point(t3, -1.549418, 53.805238, 68.1);
        p4 = new Point(t4, -1.550828, 53.805469, 70.5);

        track1 = new Track();

        track2 = new Track();
        track2.add(p1);
        track2.add(p2);
        track2.add(p3);
        track2.add(p4);
    }

    public static void print_point(Point point){
        System.out.printf("Elevation = %.1f\n", point.getElevation());
        System.out.printf("Latitude  = %.1f\n", point.getLatitude());
        System.out.printf("Longitude = %.1f\n", point.getLongitude());
        // For ZonedDateTime, convert to a String to print
        System.out.println("Time      = " + point.getTime().toString());
        // For printing using toString, no need for printf if you're just printing the string representation
        System.out.println("Point     = " + point.toString());
    }
    public static void print_track(Track track){
        System.out.print("hhhhhhhhhhh");
        System.out.printf("Size = %d\n", track.size());
        System.out.printf("Elevation = %.1f\n", track.get(0).getElevation());
        System.out.printf("Latitude  = %.1f\n", track.get(0).getLatitude());
        System.out.printf("Longitude = %.1f\n", track.get(0).getLongitude());
        // For ZonedDateTime, convert to a String to print
        System.out.println("Time      = " + track.get(1).getTime().toString());
        // For printing using toString, no need for printf if you're just printing the string representation
        System.out.println("Point     = " + track.get(1).toString());
        System.out.println(track.totalDistance());
        System.out.println(track.averageSpeed());
    }

    public static void main(String[] args)throws IOException{
        perTestSetup();
        print_point(p1);
        track1.readFile("../../../data/test.csv");
        print_track(track1);
        
    }
}