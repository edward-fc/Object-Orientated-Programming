import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * Program to general a KML file from GPS track data stored in a file,
 * for the Advanced task of COMP1721 Coursework 1.
 *
 * @author Edward Falkner-Carter
 */
public class ConvertToKML {
  public static void main(String[] args)throws FileNotFoundException,IOException {
    // OPTIONAL: implenent the ConvertToKML application here
    if (args.length < 2){
      throw new GPSException("Usage: java Convert to KML input CSV file then alwell the reapretive KML file");
    }
    String CSV_file = args[0];
    String KML_file = args[1];

    Track track = new Track();
    track.readFile(CSV_file);

    track.writeKML(KML_file);
  }
}
