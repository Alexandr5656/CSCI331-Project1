import java.util.ArrayList;
import java.util.HashMap;
public class Helper {
    public void printSearch(ArrayList<String> path,HashMap<String,City>Map,String type) {
        switch(type){
            case "BFS":
                System.out.println("Breadth-First Search Results:");
                break;
            case "DFS":
                System.out.println("Depth-First Search Results:");
                break;
            case "A*":
                System.out.println("A* Search Results:");
                break;
        }
        for(String city : path){
            System.out.println(city);
        }
        System.out.println("That took "+path.size()+" hops to find.");
        String lastCity = path.get(0);
        double totalDist = 0;
        for (int i = 1; i < path.size(); i++) {
            totalDist += calcDist(Map.get(lastCity), Map.get(path.get(i)));
            lastCity = path.get(i);
        }
        System.out.println("Total distance = " + (int) Math.ceil(totalDist) + " miles.");
    }
    public double calcDist(City city1, City city2){
        try{
            //System.out.println(city1.name+" -> "+city2.name);
            double dist = Math.sqrt( (city1.lattitude-city2.lattitude)*(city1.lattitude-city2.lattitude) + (city1.longitude-city2.longitude)*(city1.longitude-city2.longitude) ) * 100;
            //System.out.println(dist);
            return dist;

        }
        catch(Exception e){
            return 0;
        }

    }
}
