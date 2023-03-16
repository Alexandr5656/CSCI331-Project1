import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter; 
import java.io.IOException;


public class Search {
    public static void main(String[] args) {
        if(args.length<2){
          System.err.println("Usage: java Search inputFile outputFile");
          System.exit(0);
        }
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
            System.err.println("File not found: city.dat");
            System.exit(0);
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
            System.err.println("File not found: edge.dat");
            System.exit(0);
        }
        ArrayList<String> inputData=new ArrayList<String>();
        String inputFile =args[0];

        if(inputFile.equals("-")){
          Scanner scanner = new Scanner(System.in);
          System.out.println("Enter input file.");
          inputFile = scanner.nextLine();
        }
        
        try{
          
          File myObj = new File(inputFile);
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            inputData.add(myReader.nextLine());
            
          }
          myReader.close();
        } catch (Exception e) {
          System.err.println("File not found: "+ inputFile);
          System.exit(0);
      }
    
      String testCity="";
      try{
        testCity = inputData.get(0);
        cityList.get(testCity);
        testCity = inputData.get(1);
        cityList.get(testCity);
      }catch(Exception e){
        System.err.println("City not found: "+ testCity);
        System.exit(0);
      }

      City startCity = cityList.get(inputData.get(0));
      City endCity = cityList.get(inputData.get(1));










        BFS bfs = new BFS();
        ArrayList<String> bfsResults = bfs.search(startCity, endCity);


        dfs dfs = new dfs();
        ArrayList<String> dfsResults = dfs.search(startCity, endCity);;

        AStar aSearch = new AStar();
        ArrayList<String> aSeachResults = aSearch.search(startCity, endCity);;
        /***                       RESULTS                                                 **/


        Helper help = new Helper();
        String outputFile = args[1];
        if(outputFile.equals("-")){
          Scanner scanner = new Scanner(System.in);
          System.out.println("Enter output file.");
          outputFile = scanner.nextLine();
        }
        try{
        FileWriter outputWriter = new FileWriter(outputFile);
        
        help.printSearch(bfsResults,cityList,"BFS",outputWriter);
        help.printSearch(dfsResults,cityList,"DFS",outputWriter);
        help.printSearch(aSeachResults,cityList,"A*",outputWriter);
        outputWriter.close();
        }catch (IOException e) {
          System.err.println("An error occurred.");
          e.printStackTrace();
        }

        }

 }