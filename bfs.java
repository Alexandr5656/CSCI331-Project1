import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class bfs {
    public bfs() {

    }
    public LinkedList search(City Start, City End){
        Queue<City> queue = new LinkedList<>();
        HashMap<String,String> visted = new HashMap<>();
        City currentNode;
        queue.add(Start);
        while(!queue.isEmpty()){
            currentNode = queue.remove();
            //visted.put(currentNode.name,new ArrayList<>());
            for(City neighbor : currentNode.connections){
                
                if( !visted.containsKey(neighbor.name)){
                    visted.put(neighbor.name,currentNode.name);
                    queue.add(neighbor);
                }
                if(neighbor.equals(End)){
                    break;
                }
            }
        }
        LinkedList<String> path = new LinkedList<>();
        path.add(End.name);
        String lastCity="";
        path.add(lastCity);
        while(path.getLast().equals(Start.name)){
            
            lastCity = visted.get(path.getLast());
            path.add(lastCity);

        }
        return path;
    }
 }