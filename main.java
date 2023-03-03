import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;

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
              cityList.put(data[0],new City(data[0],data[1],Float.valueOf(data[2]),Float.valueOf(data[2])));
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
        bfs a = new bfs();
        LinkedList<String> b = a.search(cityList.get("Olympia"), cityList.get("SaltLakeCity"));
        for(String l : b){
            System.out.println(l);
        }
    
    
    
          
    
    
        }
 }