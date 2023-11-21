package excerciseXI;

public class Temperature {

  private String latitude, longitude, timezone, elevation, city;
  private Double temperature;

  public Temperature(
    String latitude,
    String longitude,
    String timezone,
    String elevation,
    Double temperature_2m,
    String city
  ) {
    super();
    this.latitude = latitude;
    this.longitude = longitude;
    this.timezone = timezone;
    this.elevation = elevation;
    this.temperature = temperature_2m;
    this.city = city;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public String getTimezone() {
    return timezone;
  }

  public String getElevation() {
    return elevation;
  }

  public String getCity() {
    return city;
  }

  public Double getTemperature() {
    return temperature;
  }

  @Override
  public String toString() {
    return (
      "Temperature [latitude=" +
      latitude +
      ", longitude=" +
      longitude +
      ", timezone=" +
      timezone +
      ", elevation=" +
      elevation +
      ", city=" +
      city +
      ", temperature=" +
      temperature +
      "]"
    );
  }
}
