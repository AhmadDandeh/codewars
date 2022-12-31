import java.util.Map;
import java.util.TreeMap;
public class SumOfDivided {
  private static boolean isPrime(int number){
    if(number%2==0){
      return number==2;
    }
    for(int i=3;i<=number/3;i+=2){
      if(number%i==0){
        return false;
      }
    }
    return true;
  }

  public static String sumOfDivided(int[] l) {
    String result="";
    Map<Integer,Integer> hMap=new TreeMap<>();
    hMap.clear();
    for(int i=0;i<l.length;i++){
      if(isPrime(Math.abs(l[i]))){
        if(hMap.containsKey(Math.abs(l[i]))){
          hMap.replace(Math.abs(l[i]), hMap.get(Math.abs(l[i]))+l[i]);
        }
        else{
          hMap.put(Math.abs(l[i]), l[i]);
        }
      }
      else{
        for(int j=2;j<=Math.abs(l[i])/2;j++){
          if(isPrime(j)){
            if(l[i]%j==0){
              if(hMap.containsKey(j)){
                hMap.replace(j, hMap.get(j)+l[i]);
              }
              else{
                hMap.put(j, l[i]);
              }
            }
          }
        }
      }
    }
    for(int k:hMap.keySet()){
      result+=("("+k+" "+hMap.get(k)+")");
    }
    return result;
  }
}