import java.util.PriorityQueue;
import java.util.Queue;

public class Hamming {
  public static long hamming(int n) {
    if(n<=0){
      return 0;
    }
    else if(n==1){
      return 1;
    }
    else{
      Queue<Long> q=new PriorityQueue();
      q.add(Long.valueOf(1));
      for(int i=1;i<n;i++){
        Long l=q.remove();
        if(!q.contains(l*2)){
          q.add(l*2);
        }
        if(!q.contains(l*3)){
          q.add(l*3);
        }
        if(!q.contains(l*5)){
          q.add(l*5);
        }
      }
      return q.remove();
    }
  }
}