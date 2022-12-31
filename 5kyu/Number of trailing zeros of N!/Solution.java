public class Solution {
  public static int zeros(int n){
        int numberOfZeros=0;
        for(int i=5;i<n;i*=5){
            numberOfZeros+= n/i;
        }
        return numberOfZeros;
    }
}