public class Scramblies {
  public static boolean scramble(String str1, String str2) {
    for(int i=0;i<str2.length();i++){
      int lB=str1.length();
      str1=str1.replaceFirst(""+str2.charAt(i),"");
      if(lB==str1.length())
        return false;
    }
    return true;
  }
}