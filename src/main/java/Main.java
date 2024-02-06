import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Hangman h = new Hangman();
    int lives = 7;

    //fix
    while(h.hasMoreWords()) {
      System.out.println("Guess a letter: ");
      Scanner scan = new Scanner(System.in);
      String guess = scan.nextLine();
      if(topic[0].contains(guess)) {
        System.out.println("Correct!");
      } else {
        System.out.println("Incorrect!");
        lives--;
      }
      System.out.println("Lives: " + lives);
    }

  };

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}