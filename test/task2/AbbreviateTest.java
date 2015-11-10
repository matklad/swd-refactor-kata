package task2;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class AbbreviateTest {
  @Test
  public void testUsage1() {
    String abbr = Abbreviate.abbrevEnd("London is a capital of Great Britain", 9);

    assertEquals(abbr, "London...");
  }

  @Test
  public void testUsage2() {
    String abbr = Abbreviate.abbrevEnd("London is a capital of Great Britain", 1000000);

    assertEquals(abbr, "London is a capital of Great Britain");
  }


  @Test
  public void testPropagatesNull() {
    String abbr = Abbreviate.abbrevEnd(null, 92);

    assertNull(abbr);
  }

  @Test
  public void testDonNotChangeEmptyString() {
    String abbr = Abbreviate.abbrevEnd("", 92);

    assertEquals(abbr, "");
  }

  @Test
  public void testDoNotChangeShort() {
    String abbr = Abbreviate.abbrevEnd("hello", 5);

    assertEquals(abbr, "hello");
  }


  @Test(expected = IllegalArgumentException.class)
  public void testMinLength() {
    Abbreviate.abbrevEnd("Hello", 2);
  }
}
