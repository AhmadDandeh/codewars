import java.util.stream.IntStream;
import java.util.Arrays;

public class Primes {
        private static int[] arr;
    public static IntStream stream() {
        arr = new int[1000010];
        int index = 1;
        arr[0] = 2;
        int i = 3;
        while(index<1000010){
            if(isPrime(i, index)){
                arr[index] = i;
                index++;
            }
            i += 2;
        }
        return Arrays.stream(arr);
    }
     
    public static boolean isPrime(int i, int index){
        int sqrt = (int) Math.sqrt(i);
        if(i == sqrt*sqrt)
            return false;
        for(int j = 1; j<index; j++){
            if(arr[j]>sqrt)
                return true;
            if(i%arr[j] == 0)
                return false;
        }
        return true;
    }
}