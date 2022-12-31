public class XO {
  
  public static boolean getXO (String str) {
    str = str.toLowerCase();
    return str.replaceAll("x", "").length() == str.replaceAll("o", "").length();
  }
}