class Diamond {
  public static String print(int n) {
    if ((n % 2 == 0) || (n < 0)) {
      return null;
    } 
    else {
      String str = "";
      for (int row = 0; row < n / 2; row++) {
        for (int col = 0; col < n / 2 - row; col++) {
          str += " ";
        }
        for (int col = 0; col < 2 * row + 1; col++) {
          str += "*";
        }
        str += "\n";
      }
      for (int col = 0; col < n; col++) {
        str += "*";
      }
      str += "\n";
      for (int row = 0; row < n / 2; row++) {
        for (int col = 0; col < 1 + row; col++) {
          str += " ";
        }
        for (int col = 0; col < n - 2 - 2 * row; col++) {
          str += "*";
        }
        str += "\n";
      }
      return str;
    }
  }
}