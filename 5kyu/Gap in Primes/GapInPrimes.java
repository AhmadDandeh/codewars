class GapInPrimes {
    private static boolean isPrime(long l){
        for(long i=2;i<l/2;i++){
            if(l%i==0)
                return false;
        }
        return true;
    }
    public static long[] gap(int g, long m, long n) {
        long[] l=new long[2];
        long fPrime=0;
        for(long i=m;i<=n;i++){
            if(isPrime(i)){
                fPrime=i;
                break;
            }
        }
        long sPrime=0;
        for(long i=fPrime+1;i<=n;i++){
            if(isPrime(i)){
                sPrime=i;
                if(sPrime-fPrime==g){
                    return new long[]{fPrime,sPrime};
                }
                else{
                    fPrime=sPrime;
                }
            }
        }
        return null;
    }
    
}