import java.lang.StringBuilder;
class Solution{

  static String toCamelCase(String s){
    while (s.contains("_")) {
      String c = s.charAt(s.indexOf("_") + 1) + "";
      s = s.replaceFirst("_" + c, c.toUpperCase());
    }
    while (s.contains("-")) {
      String c = s.charAt(s.indexOf("-") + 1) + "";
      s = s.replaceFirst("-" + c, c.toUpperCase());
    }
    return s;
  }
}