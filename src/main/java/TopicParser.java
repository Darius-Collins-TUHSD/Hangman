import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

public class TopicParser {
  
  private ArrayList<String> words; // parsed text file
  private ArrayList<String> hints; // hints for words

  FileReader reader;
  Scanner scan;
  Random rand;

  /**
    * Constructor for TopicParser
    * @param path - path to text file
    * @author loejuken
   */
  public TopicParser(String path) throws FileNotFoundException {
   
    reader = new FileReader(path);
    scan = new Scanner(reader); 
    rand = new Random(); // random number generator
    
    ArrayList<String> words = new ArrayList<String>();
    while(scan.hasNext()) {
      String temp = scan.nextLine();
      words.add(temp.split("-")[0]);
      hints.add(temp.split("-")[1]);
    }
    
  }

  /**
    * @return - random word[0] and hint[1] in topic list
    * @author loejuken
  **/
  public String[] getWord(){
    int index = rand.nextInt(words.size());
    String[] topic = {words.remove(index), hints.get(index)};
    return topic;
  }

  /**
    * @return if words has more possible words
    * @author loejuken
  **/
  public boolean hasMoreWords() {
    return words.size() > 0;
  }
  
}