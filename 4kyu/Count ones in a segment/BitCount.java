import java.math.BigInteger;

public class BitCount {

public static BigInteger countOnes(long left, long right) {
        return getFromZero(right).subtract(getFromZero(left-1));
    }
    
    private static BigInteger getR(long j){
        if(j==0){
            return BigInteger.ZERO;
        }
        else{
            return BigInteger.valueOf((long) Math.pow(2, j-1)).add(getR(j-1).multiply(BigInteger.valueOf(2)));
        }
    }
    
    private static long getJ(long l){
        if(l == 0){
            return 0;
        }
        else{
            long p = 0;
            while(Math.pow(2, p)<=l){
                p++;
            }
            return p-1;
        }
    }

    private static BigInteger getFromZero(long i){
        if(i==0){
            return BigInteger.ZERO;
        }
        long j = getJ(i);
        long rem = i - (long) Math.pow(2, j);
        return getR(j).add(BigInteger.valueOf(rem+1).add(getFromZero(rem)));
    }
}