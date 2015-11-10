package task1;

public class IndexOfAny {
  /**
   * Write covering tests + refactor code.
   * In this task signature should stay the same
   */
  public static int indexOfAny(String haystack, char[] needle) {
    assert haystack != null && needle != null;
    for (int i = 0; i < haystack.length(); i++) {
      for (char aNeedle : needle) {
        if (haystack.charAt(i) == aNeedle) {
          return i;
        }
      }
    }

    return -1;
  }

}
