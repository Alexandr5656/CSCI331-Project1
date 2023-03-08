import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class BFS {
    public int SearchDistance = 0;
    public ArrayList search(City Start, City End){
        Queue<City> queue = new LinkedList<>();
        HashMap<String,String> visted = new HashMap<>();
        City currentNode;
        queue.add(Start);
        while(!queue.isEmpty()){
            currentNode = queue.remove();
            Collections.sort(currentNode.connections, new bfsSort());
            for(City neighbor : currentNode.connections){//List.sort(currentNode.connections,new SortName())){
                
                if( !visted.containsKey(neighbor.name)){
                    visted.put(neighbor.name,currentNode.name);
                    queue.add(neighbor);
                }
                if(neighbor.equals(End)){
                    break;
                }
            }
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
}

class bfsSort implements Comparator<City>{
    @Override
    public int compare(City o1, City o2){
        return o1.name.compareTo(o2.name);

    }
 }
 