public class Solution{
  public static boolean validParentheses(String parens){
    int num = 0;
    for (int i = 0; i < parens.length(); i++) {
      if (parens.charAt(i) == '(') {
        num++;
      }
      else if (parens.charAt(i) == ')') {
        if (num == 0) {
          return false;
        }
        else {
          num--;
        }
      }
    }
    return num == 0;
  }
}