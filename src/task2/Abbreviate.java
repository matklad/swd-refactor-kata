package task2;

// This has only **TWO** usages int the whole project with **constant** strings,
// So the correct solution would be just to remove the whole bullshit and replace usages with
// `Abbreviate.abbreviate("London is a capital of Great Britain", 0, 9) -> "London..."`
// `Abbreviate.abbreviate("London is a capital of Great Britain", 7, 1000000); -> `"London is a capital of Great Britain"`
public class Abbreviate {
  /**
   * Write covering tests + refactor code.
   * In this task you can simplify the signature. All usages in project are listed in Usages.java
   */

  public static String abbrevEnd(String str, int maxWidth) {
    if (maxWidth < 4) {
      throw new IllegalArgumentException("Minimum abbreviation width is 4");
    }

    if (str == null) {
      return null;
    }

    // this changes behaviour, but it is OK
    if (str.length() <= maxWidth) {
      return str;
    }

    String ellipsis = "...";
    return str.substring(0, maxWidth - ellipsis.length()) + ellipsis;
  }

}
