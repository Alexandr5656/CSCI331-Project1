import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
public class Helper {
    public void printSearch(ArrayList<String> path,HashMap<String,City>Map,String type,FileWriter outputWriter) {
        try{

        outputWriter.write("\n");
        switch(type){
            case "BFS":
                outputWriter.write("Breadth-First Search Results:\n");
                break;
            case "DFS":
                outputWriter.write("Depth-First Search Results:\n");
                break;
            case "A*":
                outputWriter.write("A* Search Results:\n");
                break;
        }
        for(String city : path){
            outputWriter.write(city+"\n");
        }
        outputWriter.write("That took "+(path.size()-1)+" hops to find.\n");
        String lastCity = path.get(0);
        double totalDist = 0;
        for (int i = 1; i < path.size(); i++) {
            totalDist += calcDist(Map.get(lastCity), Map.get(path.get(i)));
            lastCity = path.get(i);
        }
        outputWriter.write("Total distance = " + Math.round(totalDist) + " miles.\n\n");
        
    }catch(Exception e){return;}
    }
    public double calcDist(City city1, City city2){
        try{
            double dist = Math.sqrt( (city1.lattitude-city2.lattitude)*(city1.lattitude-city2.lattitude) + (city1.longitude-city2.longitude)*(city1.longitude-city2.longitude) ) * 100;
            return dist;

        }
        catch(Exception e){
            return 0;
        }

    }
}
