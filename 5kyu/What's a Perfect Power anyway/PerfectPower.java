public class PerfectPower {
  public static int[] isPerfectPower(int n) {    
    int count, nCopy;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            count=0;
            nCopy=n;
            while (nCopy % i == 0) {
                nCopy /= i;
                count++;
            }
            if (nCopy == 1 && count>0) {
                if(n==Math.pow(i, count)){
                    return new int[]{i, count};
                }
            }
        }
        return null;
    }
}