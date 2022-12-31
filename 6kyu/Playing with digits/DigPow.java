public class DigPow {
	
	public static long digPow(int n, int p) {
		int newN=0;
        int nCopy=n;
        while(nCopy>0){
            newN=(nCopy%10)+newN*10;
            nCopy/=10;
        }
        long sum=0;
        while(newN>0){
            sum+=Math.pow((newN%10),p);
            newN/=10;
            p++;
        }
        if(sum%n==0){
            return sum/n;
        }
        else{
           return -1; 
        }
	}
	
}