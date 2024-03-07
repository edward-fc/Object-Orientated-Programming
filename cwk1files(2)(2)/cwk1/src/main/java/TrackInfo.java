import java.io.FileNotFoundException;
/**
 * Program to provide information on a GPS track stored in a file.
 *
 * @author Edward Falkner-Carter
 */

public class TrackInfo {
  public static void main(String[] args) throws FileNotFoundException {
    // TODO: Implementation TrackInfo application here
    // Let see if user enter a filename
    if (args.length == 0){
      throw new GPSException("No filename was provided");
    }
    String filename = args[0];
    Track track = new Track();
    // readFile() already has a erro detection 
    track.readFile(filename);
    // if sucessful printout the demanded info 
    System.out.println(track.size() + " points in track");
    System.out.println("Lower point is " + track.lowestPoint());
    System.out.println("Highest point is " + track.highestPoint());
    System.out.printf("Total distance = %.3f km\n", track.totalDistance() / 1000.0);
    System.out.printf("Total distance = %.3f m/s\n", track.averageSpeed());

  }

}
