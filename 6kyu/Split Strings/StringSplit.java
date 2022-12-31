public class StringSplit {
  public static String[] solution(String s) {
    if(s.length()%2!=0)
      s+="_";
    String[] result=new String[s.length()/2];
    for(int i=0;i<result.length;i++){
      result[i]=s.substring(2*i, 2*(i+1));
    }
    return result;
  }
}