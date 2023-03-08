import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner; // Import the Scanner class to read text files


public class main {
    public static void main(String []args) {
        String cityData = "helperFiles/city.dat";
        String edgeData = "helperFiles/edge.dat";
        HashMap<String,City> cityList = new HashMap<>();
        try {
            
            File myObj = new File(cityData);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String[] data = myReader.nextLine().split("\\s+");
              cityList.put(data[0],new City(data[0],data[1],Float.valueOf(data[2]),Float.valueOf(data[3])));
            }
            myReader.close();
          } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        try {
            
            File myObj = new File(edgeData);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String[] data = myReader.nextLine().split("\\s+");
              cityList.get(data[0]).addNeighbor(cityList.get(data[1]));
              cityList.get(data[1]).addNeighbor(cityList.get(data[0]));
            }
            myReader.close();
          } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        /**BFS
        BFS bfs = new BFS();
        ArrayList<String> bfsResults = bfs.search(cityList.get("Denver"), cityList.get("Boston"));


        dfs dfs = new dfs();
        ArrayList<String> dfsResults = dfs.search(cityList.get("Denver"), cityList.get("Boston"));
**/
        ASearch aSearch = new ASearch();
        ArrayList<String> aSeachResults = aSearch.search(cityList.get("Denver"), cityList.get("Boston"));
        /***                       RESULTS                                                 **/


        Helper help = new Helper();
        //help.printSearch(bfsResults,cityList,"BFS");
        //help.printSearch(dfsResults,cityList,"DFS");
        help.printSearch(aSeachResults,cityList,"A*");



        }

 }