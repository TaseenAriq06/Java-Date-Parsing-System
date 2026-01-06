import java.util.StringTokenizer;
import java.util.TreeMap;
public class Project4{
    public static void main(String[] args){ // creates the GUI window
        new Date212GUI();
    }
    // this is used to read and validate the file line by line and parse the string
    public static void processFile(String filename, Date212GUI gui){
        UnsortedDate212List unsortedList = new UnsortedDate212List(); // linked list to output original order values
        TreeMap<Date212, Object> sortedMap = new TreeMap<>();         // TreeMap for sorted unique dates in the GUI 

        TextFileInput in = new TextFileInput(filename);
        String line = in.readLine();

        while(line != null){                                                       // read file line by line until null
            line = line.trim();
            if(!line.isEmpty()){
                StringTokenizer tokenizer = new StringTokenizer(line, ","); // split multiple dates on the same line using comma

                while(tokenizer.hasMoreTokens()){                                 // process each token in file
                    String token = tokenizer.nextToken().trim();

                    try {
                        Date212 d = new Date212(token);
                        unsortedList.add(d);                                      // date is valid if no exception thrown
                        sortedMap.put(d, null);                            // put into a TreeMap sorted
                    } catch (IllegalDate212Exception e){
                        System.out.println(e.getMessage());                      // print exception message in output if invalid
                    }
                }
            }
            line = in.readLine();                                                // move onto the next line if valid
        }
        in.close();                                                              // close the file

        gui.displayLists(unsortedList, sortedMap);                               // GUI displays the valid results in a window
    }   
}
