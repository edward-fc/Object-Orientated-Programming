import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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
  public void readFile(String filename)throws FileNotFoundException{
    // need to clear the old point to let the new ones
    points.clear();

    try {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    scanner.nextLine();
    while (scanner.hasNextLine()){
      String file_line = scanner.nextLine();
      String[] file_data = file_line.split(",");
      // lets check if the length is 4
      if (file_data.length < 4) {
        throw new GPSException("Data file has fewer than 4 columns");
      }
      // check if the array has content
      ZonedDateTime fline_time = ZonedDateTime.parse(file_data[0]);
      double fline_longitude = Double.parseDouble(file_data[1]);
      double fline_latitude = Double.parseDouble(file_data[2]);
      double fline_elevation = Double.parseDouble(file_data[3]);

      Point point = new Point(fline_time,fline_longitude,fline_latitude,fline_elevation);
      
      points.add(point);
    }
    // Close what we have open 
    scanner.close();
    
  } catch (FileNotFoundException filenameError){
    throw new FileNotFoundException("File has not been found. the Error message is:"+filenameError);
  }catch (GPSException GPAError){
    throw new GPSException("Error during the reading of the file. The error message is:"+GPAError.getMessage());
  }
  }

  // TODO: Create a stub for add()
  public int add(Point point){
    points.add(points.size(),point);
    return 0;
  }

  // TODO: Create a stub for get()
  public Point get(int index) throws GPSException{
    if(index >= size()){
      throw new GPSException("The index out of range. Please enter integer inferior or equal to "+size());
    }
    else if (index < 0){
      throw new GPSException("The index out of range. Please enter a positive integer");
    }
    return points.get(index);
  }

  // TODO: Create a stub for size()
  public int size(){
    return points.size();
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint(){
    if (points.size() == 0){
      throw new GPSException("Please neter a track with points");
    }
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
    if (points.size() == 0){
      throw new GPSException("Please neter a track with points");
    }
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
  public double totalDistance(){
    if (points.size() < 2){
      throw new GPSException("Please make it that there are more than 2 points in the track");
    }
    double total_distance = 0;
    for (int index=1;index < size();index++){
      total_distance += Point.greatCircleDistance(points.get(index-1), points.get(index));
    }
    return total_distance;
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed(){
    if (points.size() < 2){
      throw new GPSException("Please make it that there are more than 2 points in the track");
    }
    int total_seconds = (int) ChronoUnit.SECONDS.between(points.get(0).getTime(),points.get(size()-1).getTime());
    return totalDistance()/total_seconds;
  }
}
