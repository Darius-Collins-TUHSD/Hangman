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
  
  private String[] topics = {
    "UN Countries", 
    "Foods", 
    "Movies", 
    "USA Sports Teams"
  };
  
  private ArrayList<String> words; // parsed text file
  private ArrayList<String> hints; // hints for words
  private Random rand; // random number generator
  private String path;
  private FileReader reader;
  private Scanner scan;
  private int lives;
  private String word;
  private String hint;
  private String topic;
  private String usedLetters;
  private char[] display;

  public Hangman(int topicInd) throws FileNotFoundException {
    words = new ArrayList<String>(); // parsed text file
    hints = new ArrayList<String>(); // hints for words
    rand = new Random(); // random number generator
    path = paths[topicInd];
    reader = new FileReader(path);
    scan = new Scanner(reader);
    while(scan.hasNext()) {
      String temp = scan.nextLine();
      words.add(temp.split("-")[0]);
      hints.add(temp.split("-")[1]);
    }
    topic = topics[topicInd];
    //reset();
    int index = rand.nextInt(words.size());
    this.word = words.remove(index);
    this.hint = hints.remove(index);
    for(int i = 0; i < word.length(); i++)) {
      display[i] = (Character.isSpaceChar(word.charAt(i))) ? '-' : '/';
    }
    lives = 7;
  }

  public String getWord() {
    return word;
  }

  public String getHint(int penalty) {
    lives -= penalty;
    return hint;
  }

  /**
  * Returns the hangman model, the topic, the current words
  */
  public String toString() {
    String str = "";
    str += "Topic: " + topics;
    str += "\nLives: " + lives;
    
    return str;
  }

  public void reset() {
    int index = rand.nextInt(words.size());
    this.word = words.remove(index);
    this.hint = hints.remove(index);
    for(int i = 0; i < word.length(); i++)) {
      display[i] = (Character.isSpaceChar(word.charAt(i))) ? '-' : '/';
    }
    lives = 7;
  }

  public boolean guess(String letter) {
    if(letter.length() != 1 || !Character.isLetter(letter.charAt(0)))
      throw new IllegalArgumentException("Invalid guess");
    else if(usedLetters.contains(letter))
      throw new IllegalArgumentException("Letter already guessed");
    if(word.contains(letter)) {
      for(int i = 0; i < word.length(); i++) {
        if(word.charAt(i) == letter.charAt(0))
          display[i] = letter.charAt(0);
      }
      return true;
    }
    return false;
  }

  public boolean hasMoreWords() {
    return words.size() > 0;
  }

}