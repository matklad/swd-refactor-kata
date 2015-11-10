package task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndexOfAnyTest {
  @Test
  public void testHelloWorld() {
    String haystack = "Hello, World";
    char needle[] = {'a', 'o'};

    int result = IndexOfAny.indexOfAny(haystack, needle);

    Assert.assertTrue(result == 4);
  }

  @Test
  public void testMissing() {
    String haystack = "Hello, World";
    char needle[] = {'x', 'y'};

    int result = IndexOfAny.indexOfAny(haystack, needle);

    Assert.assertTrue(result == -1);
  }

  @Test
  public void testEmptyNeedle() {
    String haystack = "Hello, World";
    char needle[] = {};

    int result = IndexOfAny.indexOfAny(haystack, needle);

    Assert.assertTrue(result == -1);
  }

  @Test
  public void testEmptyHaystack() {
    String haystack = "Hello, World";
    char needle[] = {'x'};

    int result = IndexOfAny.indexOfAny(haystack, needle);

    Assert.assertTrue(result == -1);
  }

  @Test
  public void testEdgeCase() {
    String haystack = "x_";
    char needle[] = {'x', 'y'};

    int result = IndexOfAny.indexOfAny(haystack, needle);

    Assert.assertTrue(result == 0);
  }

  // This is not a unit test, but property based tests are extremely efficient for testing algorithms.
  //
  // Yay! It fond a bug in the original implementation. Property based testing rocks when it is applicable!
  @Test
  public void testQuickCheck() {
    Random r = new Random();

    int haystackLength = r.nextInt(10);
    int needleLength = r.nextInt(5);

    for (int tries = 0; tries < 1000; tries++) {
      String haystack = String.valueOf(randomChars(haystackLength));

      char needle[] = randomChars(needleLength);
      List<Character> needleChars = new ArrayList<>();

      for (char c : needle) {
        needleChars.add(c);
      }

      int result = IndexOfAny.indexOfAny(haystack, needle);
      String msg = haystack + " " + String.valueOf(needle) + " " + result;

      if (result == -1) {
        for (char c : haystack.toCharArray()) {
          Assert.assertFalse(msg, needleChars.contains(c));
        }

      } else {
        char match = haystack.charAt(result);
        Assert.assertTrue(needleChars.contains(match));
      }
    }
  }

  private char[] randomChars(int length) {
    Random r = new Random();
    char needle[] = new char[length];
    for (int i = 0; i < length; i++) {
      needle[i] = (char) ('a' + r.nextInt(10));
    }
    return needle;
  }

}
