import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
  private static String[] paths = {
    "src/main/java/Countries.txt",
    "src/main/java/Foods.txt",
    "src/main/java/Movies.txt",
    "src/main/java/USASports.txt"
  };
  private ArrayList<String> words; // parsed text file
  private ArrayList<String> hints; // hints for words
  private Random rand; // random number generator
  private String path;
  private FileReader reader;
  private Scanner scan;
  
  private String word;
  private String hint;
  private int lives;
  private String guessedLetters;

  public Hangman() throws FileNotFoundException {
    words = new ArrayList<String>(); // parsed text file
    hints = new ArrayList<String>(); // hints for words
    rand = new Random(); // random number generator
    path = paths[rand.nextInt(paths.length)];
    reader = new FileReader(path);
    scan = new Scanner(reader);
    while(scan.hasNext()) {
      String temp = scan.nextLine();
      words.add(temp.split("-")[0]);
      hints.add(temp.split("-")[1]);
    }
    
    int index = rand.nextInt(words.size());
    this.word = words.remove(index);
    this.hint = hints.remove(index);
    this.lives = 6;
    this.guessedLetters = "";
  }

  public String getWord() {
    return word;
  }

  public String getHint() {
    return hint;
  }
  
  public int getLives() {
    return lives;
  }

  

  //finish
  public void reset() {
    
  }

  public boolean hasMoreWords() {
    return words.size() > 0;
  }

}