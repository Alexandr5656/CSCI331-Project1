import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class AStar {
    public int SearchDistance = 0;
    public ArrayList search(City Start, City End){
        Queue<City> queue = new LinkedList<>();
        HashMap<String,String> visted = new HashMap<>();
        HashMap<Double,City> distCost = new HashMap();
        City currentNode = Start;
        queue.add(Start);
        while(1==1){
            if(currentNode.equals(End))
                break;
            for(City neighbor : currentNode.connections){
                
                if( !visted.containsKey(neighbor.name)){
                    visted.put(neighbor.name,currentNode.name);
                    distCost.put(calcA(Start,End,neighbor),neighbor);
                }
                if(neighbor.equals(End)){
                    break;
                }
            }
            //visted.put(distCost.get(Collections.min(distCost.keySet())).name,currentNode.name);
            currentNode = distCost.get(Collections.min(distCost.keySet()));
            
            distCost.remove(Collections.min(distCost.keySet()));
            
        }
        ArrayList<String> path = new ArrayList<>();
        path.add(End.name);
        String lastCity="";
        
        while(!path.get(0).equals(Start.name)){
            ///TODO: Fix this up
            lastCity = visted.get(path.get(0));
            path.add(0,lastCity);
        }
        return path;
    }
    public double calcA(City start,City end,City city){
        Helper help = new Helper();
        return help.calcDist(start,city)+help.calcDist(end,city);
    
    }

}


 