package ExerciseIX;

import ExerciseVII.Api;
import ExerciseVII.FileWritter;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    final String URL = "https://rickandmortyapi.com/api/character";
    Api api = new Api(URL);
    try {
      List<RickMorty> rm = api.getRickMorty();
      FileWritter f = new FileWritter(
        "C:\\Users\\pablo\\Desktop\\Cursos Pablo\\Java\\rick&morty.txt",
        true
      );
      f.WriteAllTxt(rm);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
