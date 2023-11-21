package ExerciseVII;

public class Main {

  public static void main(String[] args) {
    final String URL = "https://pokeapi.co/api/v2/pokemon/ditto";
    Api api = new Api(URL);
    try {
      Pokemon p = api.getPokemon();
      FileWritter f = new FileWritter(
        "C:\\Users\\pablo\\Desktop\\Cursos Pablo\\Java\\pokemon.txt",
        true
      );
      f.WriteOneTxt(p);
      System.out.println(p.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
