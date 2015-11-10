package task3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {
  private final String q;
  private final int correct;
  private final String[] answers;

  // package private, so not a public api
  Question(String q, int correct, String... answers) {
    assert (0 <= correct && correct < answers.length);
    this.q = q;
    this.answers = answers;
    this.correct = correct;
  }

  @Override
  public String toString() {
    return q;
  }

  public boolean checkAnswer(String answer) {
    return answers[correct].equals(answer);
  }

  public List<String> answers() {
    return Collections.unmodifiableList(Arrays.asList(answers));
  }
}
