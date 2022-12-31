import java.util.Arrays;
import java.util.ArrayList;
public class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      if (n <= 0) {
        return Integer.MAX_VALUE;
      } 
      else if (customers.length <= 0) {
        return 0;
      } 
      else {
        int expTime = 0;
        int[] servers = new int[n];
        int index = 0;
        ArrayList<Integer> sNW = new ArrayList<>();
        sNW.clear();
        for(int i=0;i<n;i++){
          sNW.add(i);
        }
        while (true) {
          while (!sNW.isEmpty()) {
            if (index >= customers.length) {
              break;
            } 
            else {
              servers[sNW.remove(0)] = customers[index];
              index++;
            }
          }
          int smallTime = Integer.MAX_VALUE;
          for (int i = 0; i < servers.length; i++) {
            if ((servers[i] > 0) && (servers[i] < smallTime)) {
              smallTime = servers[i];
            }
          }
          if (smallTime != Integer.MAX_VALUE) {
            expTime += smallTime;
            for(int i=0;i<servers.length;i++){
              servers[i]-=smallTime;
              if(servers[i]==0){
                sNW.add(i);
              }
            }
          } 
          else {
            return expTime;
          }
        }
      }
    }
}