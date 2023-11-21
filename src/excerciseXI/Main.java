package excerciseXI;

import ExerciseVII.Api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {

  public static void main(String[] args) {
    final String URL = "https://api.open-meteo.com/v1/forecast?";
    List<Temperature> lt = new ArrayList<>();
    Map<String, CityCoor> cities = Stream
      .of(
        new Object[][] {
          { "Barcelona", new CityCoor("41.3", "2.1") },
          { "Madrid", new CityCoor("40.4", "-3.7") },
          { "Berlin", new CityCoor("52.5", "13.4") },
          { "Buenos aires", new CityCoor("34.6", "58.4") },
        }
      )
      .collect(Collectors.toMap(p -> (String) p[0], p -> (CityCoor) p[1]));

    for (String k : cities.keySet()) {
      Api api = new Api(
        URL +
        "latitude=" +
        cities.get(k).getLatitude() +
        "&latitude&longitude=" +
        cities.get(k).getLongitude() +
        "&hourly=temperature_2m"
      );
      lt.add(api.getTemperatures(k));
    }
    new JFrameConBotones(lt);
  }
}
