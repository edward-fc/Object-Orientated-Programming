import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;


/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author Edward Falkner-Carter
 */
public class Track {
  // TODO: Create a stub for the constructor
  private List<Point> points;

  public Track(){
    points = new ArrayList<>();
  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename){
    try {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()){
      String file_line = scanner.nextLine();
      String[] file_data = file_line.split(",");
      // check if the array has content
      ZonedDateTime time = ZonedDateTime.parse(file_data[0]);
      double longitude = Double.parseDouble(file_data[1]);
      double latitude = Double.parseDouble(file_data[2]);
      double elevation = Double.parseDouble(file_data[3]);

      Point point = new Point(time,longitude,latitude,elevation);

      points.add(point);
    }
    // Close what we have open 
    scanner.close();
  } catch (FileNotFoundException filenameError){
    System.err.println("File has not been found. the Error message is:"+filenameError);
  }catch (GPSException GPAError){
    System.err.println("Error during the reading of the file. The error message is:"+GPAError.getMessage());
  }
  }

  // TODO: Create a stub for add()
  public int add(Point point){
    points.add(point);
    return 0;
  }

  // TODO: Create a stub for get()
  public Point get(int index) throws GPSException{
    if(index > size()){
      throw new GPSException("The index out of range. Please enter integer inferior or equal to "+size());
    }
    if (index < 0){
      throw new GPSException("The index out of range. Please enter a positive integer");
    }
    return points.get(index);
  }

  // TODO: Create a stub for size()
  public int size(){
    int size_index = 0;
    while (points.get(size_index) != null){
      size_index ++;
    }
    return size_index;
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint(){
    double lowest_elevation = points.get(0).getElevation();
    int lowest_point_index = 0;
    for (int index = 1;index < size();index ++){
      if (points.get(index).getElevation() < lowest_elevation){
        lowest_elevation = points.get(index).getElevation();
        lowest_point_index = index;
      }
    }
    return points.get(lowest_point_index);
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint(){
    double highest_elevation = points.get(0).getElevation();
    int highest_point_index = 0;
    for (int index = 1;index < size();index ++){
      if (points.get(index).getElevation() > highest_elevation){
        highest_elevation = points.get(index).getElevation();
        highest_point_index = index;
      }
    }
    return points.get(highest_point_index);
  }

  // TODO: Create a stub for totalDistance()

  // TODO: Create a stub for averageSpeed()
}
