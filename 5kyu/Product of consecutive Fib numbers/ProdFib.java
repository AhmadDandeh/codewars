public class ProdFib {
	
	public static long[] productFib(long prod) {
    long fib1=0,fib2=1,fib3=fib1+fib2;
        while(fib3*fib2<prod){
            fib1=fib2;
            fib2=fib3;
            fib3=fib1+fib2;
        }
        if(fib3*fib2==prod){
            return new long[]{fib2,fib3,1};
        }
        else{
            return new long[]{fib2,fib3,0};
        }
   }
}