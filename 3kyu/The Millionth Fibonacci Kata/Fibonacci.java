import java.math.BigInteger;

public class Fibonacci {
    private static BigInteger next1(BigInteger a, BigInteger b){
        return a.add(b);
    }
    
    private static BigInteger next2(BigInteger a, BigInteger b){
        return a.add(b).add(b);
    }
    
    private static BigInteger next6(BigInteger a, BigInteger b){
        return a.multiply(BigInteger.valueOf(5)).add(b.multiply(BigInteger.valueOf(8)));
    }
    
    private static BigInteger next7(BigInteger a, BigInteger b){
        return a.multiply(BigInteger.valueOf(8)).add(b.multiply(BigInteger.valueOf(13)));
    }
    
    private static BigInteger next40(BigInteger a, BigInteger b){
        return a.multiply(BigInteger.valueOf(63245986)).add(b.multiply(BigInteger.valueOf(102334155)));
    }
    
    private static BigInteger next41(BigInteger a, BigInteger b){
        return a.multiply(BigInteger.valueOf(102334155)).add(b.multiply(BigInteger.valueOf(165580141)));
    }
    
    private static BigInteger getPOS(BigInteger n){
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;
        
        // Divide on 40
        BigInteger div40 = n.divide(BigInteger.valueOf(40));
        BigInteger mod40 = n.mod(BigInteger.valueOf(40));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(div40)==-1;i=i.add(BigInteger.ONE)){
            c=next40(a, b);
            b=next41(a, b);
            a=c;
        }
        
        BigInteger div6 = mod40.divide(BigInteger.valueOf(6));
        BigInteger mod6 = mod40.mod(BigInteger.valueOf(6));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(div6)==-1;i=i.add(BigInteger.ONE)){
            c=next6(a, b);
            b=next7(a, b);
            a=c;
        }
        
        BigInteger div2 = mod6.divide(BigInteger.valueOf(2));
        BigInteger mod2 = mod6.mod(BigInteger.valueOf(2));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(div2)==-1;i=i.add(BigInteger.ONE)){
            c=next1(a, b);
            b=next2(a, b);
            a=c;
        }
        
        if(mod2.equals(BigInteger.ZERO)){
            return a;
        }
        else{
            return b;
        }
    }
    
    private static BigInteger prev1(BigInteger a, BigInteger b){
        return b.subtract(a);
    }
    
    private static BigInteger prev2(BigInteger a, BigInteger b){
        return a.add(a).subtract(b);
    }
    
    private static BigInteger prev6(BigInteger a, BigInteger b){
        return b.multiply(BigInteger.valueOf(5)).subtract(a.multiply(BigInteger.valueOf(8)));
    }
    
    private static BigInteger prev7(BigInteger a, BigInteger b){
        return a.multiply(BigInteger.valueOf(13)).subtract(b.multiply(BigInteger.valueOf(8)));
    }
    
    private static BigInteger prev40(BigInteger a, BigInteger b){
        return b.multiply(BigInteger.valueOf(63245986)).subtract(a.multiply(BigInteger.valueOf(102334155)));
    }
    
    private static BigInteger prev41(BigInteger a, BigInteger b){
        return a.multiply(BigInteger.valueOf(165580141)).subtract(b.multiply(BigInteger.valueOf(102334155)));
    }
    
    private static BigInteger getNEG(BigInteger n){
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ZERO;
        BigInteger c = BigInteger.ZERO;
        n=n.abs();
        
        // Divide on 40
        BigInteger div40 = n.divide(BigInteger.valueOf(40));
        BigInteger mod40 = n.mod(BigInteger.valueOf(40));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(div40)==-1;i=i.add(BigInteger.ONE)){
            c=prev40(a, b);
            a=prev41(a, b);
            b=c;
        }
        
        BigInteger div6 = mod40.divide(BigInteger.valueOf(6));
        BigInteger mod6 = mod40.mod(BigInteger.valueOf(6));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(div6)==-1;i=i.add(BigInteger.ONE)){
            c=prev6(a, b);
            a=prev7(a, b);
            b=c;
        }
        
        BigInteger div2 = mod6.divide(BigInteger.valueOf(2));
        BigInteger mod2 = mod6.mod(BigInteger.valueOf(2));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(div2)==-1;i=i.add(BigInteger.ONE)){
            c=prev1(a, b);
            a=prev2(a, b);
            b=c;
        }
        
        if(mod2.equals(BigInteger.ZERO)){
            return b;
        }
        else{
            return a;
        }
    }
    
    public static BigInteger fib(BigInteger n) {
        if(n==BigInteger.ZERO){
            return BigInteger.ZERO;
        }
        else if(n==BigInteger.ONE){
            return BigInteger.ONE;
        }
        else if(n.compareTo(BigInteger.ZERO)==-1){
            return getNEG(n);
        }
        else{
            return getPOS(n);
        }
    }

}