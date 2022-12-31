import java.math.BigInteger;
public class SumFct {
	public static BigInteger perimeter(BigInteger n) {
        BigInteger b1=new BigInteger("1");
        BigInteger b2=new BigInteger("1");
        if(n.equals(BigInteger.ZERO)){
            return new BigInteger("0");
        }
        else if(n.equals(BigInteger.ONE)){
            return b1.multiply(BigInteger.valueOf(4));
        }
        else if(n.equals(BigInteger.valueOf(2))){
            return b1.add(b2).multiply(BigInteger.valueOf(4));
        }
        else{
            BigInteger sum=new BigInteger("0");
            sum=sum.add(b1).add(b2);
            BigInteger b3=new BigInteger("0");
            n=n.subtract(BigInteger.ONE);
            while(!n.equals(BigInteger.ZERO)){
                b3=b1.add(b2);
                sum=sum.add(b3);
                b1=b2;
                b2=b3;
                n=n.subtract(BigInteger.ONE);
            }
            return sum.multiply(BigInteger.valueOf(4));
        }
    }

}