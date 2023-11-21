package ExerciseVII;

public class Pokemon {

  private String name, type;
  private Integer weight;

  public Pokemon(String name, String type, Integer weight) {
    super();
    this.name = name;
    this.type = type;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return (
      "Pokemon [name=" + name + ", type=" + type + ", weight=" + weight + "]"
    );
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }
}
