import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;



public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    JOptionPane.showMessageDialog(null, "Welcome to Hangman!");
    String[] options = {"UN Countries", "Foods", "Movies", "USA Sports Teams"};
    int topic = JOptionPane.showOptionDialog(null, "Choose a topic:", "Hangman", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
    Hangman game = new Hangman(topic);
    Scanner scan = new Scanner(System.in);
    //fix
    while(game.hasMoreWords()) {
      startGame(options[topic]);
    }

    System.out.println("Thanks for playing!");
    scan.close();

  };

  /**
  * Method - one game of hangman 
  * @param topic - the topic of the game
  **/
  public static boolean startGame(String[] topic) {

    JOptionPane.showInputDialog(game.toString());
    
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}