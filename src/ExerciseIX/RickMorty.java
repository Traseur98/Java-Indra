package ExerciseIX;

public class RickMorty {

  private String name, status, species, gender, location;

  public RickMorty(
    String name,
    String status,
    String species,
    String gender,
    String location
  ) {
    super();
    this.name = name;
    this.status = status;
    this.species = species;
    this.gender = gender;
    this.location = location;
  }

  @Override
  public String toString() {
    return (
      "Character [name=" +
      name +
      ", status=" +
      status +
      ", species=" +
      species +
      ", gender=" +
      gender +
      ", location=" +
      location +
      "]"
    );
  }
}
