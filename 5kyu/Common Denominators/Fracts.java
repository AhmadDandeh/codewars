import java.util.ArrayList;
public class Fracts {
   
    private static boolean isPrime(long l){
        for(long i=2;i<l/2;i++){
            if(l%i==0)
                return false;
        }
        return true;
    }
    
    private static ArrayList<Long> numG(long num){
        ArrayList<Long> l=new ArrayList<>();
        l.clear();
        for(long i=2;i<=num;i++){
            if(isPrime(i)){
                if(num%i==0){
                    l.add(i);
                    num/=i;
                    i--;
                }
                if(num==1){
                    break;
                }
            }
        }
        return l;
    }
    
    private static int getArrayHeight(long[][] arr){
        int x=0;
        for(long[] l:arr){
            for(long j:l){
                x++;
            }
        }
        return x/2;
    }
    
    private static ArrayList<Long> getShared(ArrayList<Long> l1,ArrayList<Long> l2){
        l1.stream().filter((ll) -> (l2.contains(ll))).forEachOrdered((ll) -> {
            l2.remove(ll);
        });
        l2.forEach((ll) -> {
            l1.add(ll);
        });
        return l1;
    }
    
    public static String convertFrac(long[][] lst) {
        int height=getArrayHeight(lst);
        for(int j=0;j<height;j++){
            ArrayList<Long> l=numG(lst[j][0]);
            if(l!=null){
                for(long k:l){
                    if(lst[j][1]%k==0){
                        lst[j][1]/=k;
                        lst[j][0]/=k;
                    }
                }
            }
        }
        ArrayList<ArrayList<Long>> l=new ArrayList<>();
        l.clear();
        for(int j=0;j<height;j++){
            l.add(numG(lst[j][1]));
        }
        
        ArrayList<Long> res=new ArrayList<>();
        res.clear();
        for(ArrayList<Long> ll:l){
            res=getShared(res, ll);
        }
        
        long b=1;
        for(Long number:res){
            b*=number;
        }
        
        String s="";
        for(int j=0;j<height;j++){
            long k=b/lst[j][1];
            lst[j][0]*=k;
            lst[j][1]=b;
            s+=("("+lst[j][0]+","+lst[j][1]+")");
        }
        return s;
    }

}