// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.chart.LineChart;
// import javafx.scene.chart.NumberAxis;
// import javafx.scene.chart.XYChart;
// import javafx.stage.Stage;
// import java.io.FileNotFoundException;

/**
 * JavaFX application to plot elevations of a GPS track, for the
 * Advanced task of COMP1721 Coursework 1.
 *
 * @author Edward Falkner-Carter
 */
public class PlotApplication{

  // If attempting the Advanced task, implement your plotting code here.
  // You will need to modify this class definition so that it extends
  // javafx.application.Application Stage stage
  public void start() { //throws FileNotFoundException
    //Setup the chart where we are gonna use distance km and m for elevation
    // NumberAxis xAxis = new NumberAxis();
    // xAxis.setLabel("Distance (km)");
    
    // NumberAxis yAxis = new NumberAxis();
    // yAxis.setLabel("Elevation (m)");

    // LineChart<Number, Number> lineChart = new LineChart<>(xAxis,yAxis);
    // XYChart.Series<Number,Number> series = new XYChart.Series<>();
    // series.setName("Elevation");
    // // Load all the point into the chart
    // Track track = new Track();
    // track.readFile("../../../data/walk.csv");
    // series.getData().add(new XYChart.Data<>(0, track.get(0).getElevation()));
    // double totalDistance = 0;
    // for (int index = 1; index < track.size(); index ++){
    //   totalDistance += Point.greatCircleDistance(track.get(index-1), track.get(index));
    //   series.getData().add(new XYChart.Data<>(totalDistance,track.get(index).getElevation()));
    // }
    // // now show the chart
    // lineChart.getData().add(series);
    
    // Scene scene = new Scene(lineChart, 800, 600);
    // stage.setScene(scene);
    // stage.show();   

  }
  public static void main(String[] args) {
    // If attempting the Advanced task, uncomment the line below
    //launch(args);
  }
}
