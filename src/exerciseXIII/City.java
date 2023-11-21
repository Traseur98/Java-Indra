package exerciseXIII;

public class City implements CityIntr{
    private String name;
    private Integer population,land,population2030,landOcuped;

    public City(String name, Integer population, Integer land) {
        this.name = name;
        this.population = population;
        this.land = land;
        population2030 = Population2030();
        landOcuped = GetLand();
    }

    @Override
    public Integer Population2030() {
        double p = population * 0.9;
        return (int)p;
    }

    @Override
    public Integer GetLand() {
       return land + 1000;
    }

    @Override
    public String toString() {
        return "City [name=" + name + ", population=" + population + ", land=" + land + ", population2030="
                + population2030 + ", landOcuped=" + landOcuped + "]";
    }
    
}
