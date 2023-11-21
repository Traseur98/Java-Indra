package ExerciseVII;

import ExerciseIX.RickMorty;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import excerciseXI.Temperature;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Api {

  private String url;
  private HttpURLConnection conn;

  public Api(String url) {
    this.url = url;
    try {
      URL ur = new URL(url);
      this.conn = (HttpURLConnection) ur.openConnection();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public Pokemon getPokemon() throws Exception {
    try {
      String json = this.connect();
      JsonObject j = JsonParser.parseString(json).getAsJsonObject();
      JsonArray l = j.get("types").getAsJsonArray();
      JsonObject types = JsonParser
        .parseString(l.get(0).toString())
        .getAsJsonObject();
      return new Pokemon(
        j.get("name").toString(),
        types.get("type").getAsJsonObject().get("name").toString(),
        Integer.parseInt(j.get("weight").toString())
      );
    } catch (Exception e) {
      throw e;
    }
  }

  public String getCatUrl() throws Exception {
    try {
      String json = this.connect();
      JsonArray j = JsonParser.parseString(json).getAsJsonArray();
      return j.get(0).getAsJsonObject().get("url").toString();
    } catch (Exception e) {
      throw e;
    }
  }

  public List<RickMorty> getRickMorty() throws Exception {
    List<RickMorty> res = new ArrayList<>();
    try {
      String json = this.connect();
      JsonObject j = JsonParser.parseString(json).getAsJsonObject();
      JsonArray lis = j.get("results").getAsJsonArray();
      Consumer<JsonElement> cons = new Consumer<JsonElement>() {
        public void accept(JsonElement t) {
          JsonElement jo = parseNestedJson(t, "location");
          String location = parseJsonString(jo, "name");
          RickMorty c = new RickMorty(
            parseJsonString(t, "name"),
            parseJsonString(t, "status"),
            parseJsonString(t, "species"),
            parseJsonString(t, "gender"),
            location
          );
          res.add(c);
        }
      };
      lis.forEach(cons);
      return res;
    } catch (Exception e) {
      throw e;
    }
  }

  public Temperature getTemperatures(String city) {
    String json;
    try {
      json = this.connect();
      JsonObject j = JsonParser.parseString(json).getAsJsonObject();
      JsonObject jn = parseNestedJson(j, "hourly");
      return new Temperature(
        parseJsonString(j, "latitude"),
        parseJsonString(j, "longitude"),
        parseJsonString(j, "timezone"),
        parseJsonString(j, "elevation"),
        parseJsonArray(jn, "temperature_2m").get(0).getAsDouble(),
        city
      );
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  private String connect() throws Exception {
    try {
      this.conn.setRequestMethod("GET");
      this.conn.connect();
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(conn.getInputStream())
      );
      String line;
      StringBuilder response = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();
      return response.toString();
    } catch (Exception e) {
      throw e;
    }
  }

  private String parseJsonString(JsonElement json, String property) {
    return json.getAsJsonObject().get(property).getAsString();
  }

  private JsonObject parseNestedJson(JsonElement json, String property) {
    return json.getAsJsonObject().get(property).getAsJsonObject();
  }

  private JsonArray parseJsonArray(JsonObject json, String property) {
    return json.getAsJsonObject().get(property).getAsJsonArray();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public HttpURLConnection getConn() {
    return conn;
  }

  public void setConn(HttpURLConnection conn) {
    this.conn = conn;
  }
}
