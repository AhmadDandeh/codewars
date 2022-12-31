public class Accumul {
  
  public static String accum(String s) {
    String result="";
    for(int i=0;i<s.length();i++){
      result+=(s.charAt(i)+"").toUpperCase();
      for(int j=1;j<=i;j++){
        result+=(s.charAt(i)+"").toLowerCase();
      }
      result+="-";
    }
    return result.substring(0, result.length()-1);
  }
}