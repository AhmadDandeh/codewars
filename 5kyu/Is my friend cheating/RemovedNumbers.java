import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {
	
  public static List<long[]> removNb(long n) {
	  long sum = (n + 1) * n / 2;
    List<long[]> list = new ArrayList<>();
    int index=0;
    for (long i = (long) (n*0.5); i < Math.sqrt(sum); i++) {
      for (long j = (long) (sum/i)-2; j <= n; j++) {
        if (i * j > sum) {
          break;
        }
        else if ((i * j + i + j) == sum) {
          list.add(index,new long[]{i, j});
          list.add(index+1,new long[]{j, i});
          index++;
          break;
        }
      }
    }
    return list;}
}