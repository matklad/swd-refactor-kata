package task3;

import java.util.Scanner;

/**
 * Simplify and make Game API more robust where possible
 */
public class WhoWantsToBeAMillionaire {
  public static void main(String[] args) {
    Game game = new Game.Builder()
        .addQuestion(
            "What is the Capital of Great Britain?",

            "Paris", "Karaganda", "Dublin", "London",

            "London")
        .addQuestion(
            "Who is the author of Godfather novel?",

            "Hemingway", "Puzo", "Vonnegut", "Tolstoy",

            "Puzo")
        .addQuestion(
            "What is the distance to the Moon?",

            "156 000 km", "384 000 km", "432 000 km", "521 000 km",

            "384 000 km")
        .build();

    Scanner scanner = new Scanner(System.in);

    for (Question q : game.getQuestions()) {
      System.out.println(q);
      for (int i = 0; i < q.answers().size(); i++) {
        System.out.println(i + ". " + q.answers().get(i));
      }

      String playerGuess = scanner.nextLine();
      if (!q.checkAnswer(playerGuess)) {
        throw new RuntimeException("You failed!");
      }
      System.out.println("Correct!");
    }

    System.out.println("Take your Million!");
  }
}
