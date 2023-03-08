import java.util.ArrayList;
import java.util.HashMap;

public class ASearch {
    public ArrayList<String> search(City start, City end){
        Helper help = new Helper();
        ArrayList<String> Path = new ArrayList<>();
        City currentCity = start;
        Path.add(currentCity.name);
        while(!currentCity.equals(end)){
            City testCity =  null;
            for(City city : currentCity.connections){
                if(!Path.contains(city.name)){
                    if(testCity == null){
                        testCity = city;
                        continue;
                    }
                    testCity = getLowestCity(start,end,testCity,city);
                }
            }
            currentCity = testCity;
            System.out.println(currentCity.name);
            Path.add(testCity.name);
        }
        return Path;
    }
    public City getLowestCity(City start,City end,City testCity,City city){
        Helper help = new Helper();
        if((help.calcDist(start,testCity)+help.calcDist(end,testCity))<(help.calcDist(start,city)+help.calcDist(end,city)))
            return testCity;
        else
            return city;

    }
 }