import java.lang.Long;
import java.util.ArrayList;
import java.util.List;
public class City {
    public Float longitude;
    public Float lattitude;
    public String name;
    public String state;
    public List<City> connections = new ArrayList<>();
    public City(String Name, String State, Float lon, Float lat){
        this.longitude = lon;
        this.lattitude=lat;
        this.name=Name;
        this.state = State;
    }
    public void addNeighbor(City city){
        connections.add(city);
    }
    public String getName(){
        return this.name;
    }
  
}

