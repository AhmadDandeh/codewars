class Solution {
  public static String camelCase(String input) {
    String result="";
    for(int i=0;i<input.length();i++){
      if((input.charAt(i)+"").toUpperCase().equals(input.charAt(i)+"")){
        result+=" "+input.charAt(i);
      }
      else{
        result+=(""+input.charAt(i));
      }
    }
    return result;
  }
}