import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class dfs {
    public ArrayList<String> search(City Start, City End){
        Stack<City> stack = new Stack<>();
        HashMap<String,String> visted = new HashMap<>();
        City currentNode;
        stack.add(Start);
        while(!stack.isEmpty()){
            currentNode = stack.pop();
            Collections.sort(currentNode.connections, new dfsSort());
            for(City neighbor : currentNode.connections){//List.sort(currentNode.connections,new SortName())){

                if( !visted.containsKey(neighbor.name)){
                    visted.put(neighbor.name,currentNode.name);
                    stack.add(neighbor);
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
class dfsSort implements Comparator<City>{
    @Override
    public int compare(City o1, City o2){
        return o2.name.compareTo(o1.name);

    }
}
 