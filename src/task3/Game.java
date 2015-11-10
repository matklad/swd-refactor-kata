package task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
  // A game is a list of questions.
  // In some sense it is a useless wrapper, but lets leave it because of possible future extensions
  // (game.theLongestQuestion(), for example)
  private Game(List<Question> questions) {
    this.questions = questions;
  }

  private List<Question> questions = new ArrayList<>();

  public List<Question> getQuestions() {
    return Collections.unmodifiableList(questions);
  }

  // Builder allows us to make a game stateless
  public static class Builder {

    private List<Question> questions = new ArrayList<>();

    public Builder() {

    }

    public Game build() {
      return new Game(questions);
    }

    // We can extract some question builder out of this, but current API already provides a nice DSL for creating questions,
    // if linebreaks are used properly.
    //
    // Changing correctAnsw from string to index or a special method would just create
    // noise. Instead, we will check at runtime that correctAnswer is among answers.
    public Builder addQuestion(String q, String answ1, String answ2, String answ3, String answ4, String correctAnsw) {
      String answers[] = {answ1, answ2, answ3, answ4};
      checkDuplicates(answers);
      int correct = findIndexOfCorrect(answers, correctAnsw);

      questions.add(new Question(q, correct, answ1, answ2, answ3, answ4));
      return this;
    }

    private void checkDuplicates(String[] answers) {
      for (int i = 0; i < answers.length; i++) {
        if (answers[i] == null || answers[i].equals("")) {
          throw new IllegalArgumentException("Empty answer");
        }
        for (int j = i + 1; j < answers.length; j++) {
          if (answers[i].equals(answers[j])) {
            throw new IllegalArgumentException("Duplicate answer: " + answers[i]);
          }
        }
      }
    }

    private int findIndexOfCorrect(String[] answers, String correctAns) {
      int correct = -1;
      for (int i = 0; i < answers.length; i++) {
        if (answers[i].equals(correctAns)) {
          correct = i;
        }
      }
      if (correct == -1) {
        throw new IllegalArgumentException("Invalid correctAnswer: " + correctAns);
      }

      return correct;
    }
  }

}
