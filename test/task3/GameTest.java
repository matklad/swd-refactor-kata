package task3;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

  @Test(expected = IllegalArgumentException.class)
  public void testBuilderChecksAnswerIsPresent() {
    new Game.Builder().addQuestion(
        "huh?",
        "a", "b", "c", "d",
        "e"
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBuilderChecksForDuplicateQuestions() {
    new Game.Builder().addQuestion(
        "huh?",
        "a", "b", "c", "a",
        "a"
    );
  }

  @Test
  public void testBuilderCreatesGame() {
    Game g = new Game.Builder()
        .addQuestion(
            "huh?",
            "a", "b", "c", "d",
            "a"
        )
        .addQuestion(
            "How many falls?",
            "1", "2", "3", "92",
            "92"
        )
        .build();

    assertEquals(g.getQuestions().size(), 2);
  }

  // Intentionally not a unit test
  @Test
  public void testGameWorks() {
    Question question = new Game.Builder().addQuestion(
        "huh?",
        "a", "b", "c", "d",
        "a"
    ).build().getQuestions().get(0);

    assertFalse(question.checkAnswer("x"));
    assertFalse(question.checkAnswer("b"));
    assertTrue(question.checkAnswer("a"));
  }
}
