import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;

public class IntPart {
    private static ArrayList<Long> primeN;
    private static TreeMap<Long,Long> tMap; // key is the number ... value is the sum of devisor
    private static int lastArraySize;
    private static HashMap<Long,Long> tMapHelp;
    private static long basicN;
    
    public static String part(long n){
        primeN = new ArrayList<>();
        primeN.clear();
        fillPrimeN(n);
        
        tMap=new TreeMap<>();
        tMap.clear();
        
        tMapHelp = new HashMap<>();
        tMapHelp.clear();
        
        basicN = n;
        lastArraySize = 1;
        getFinalArrList(n);
        Object[] toArray = tMap.keySet().toArray();
        
        Long range = (Long) toArray[toArray.length-1] - 1;
        double avg = getAverage(toArray);
        double med = getMedian(toArray);
        return "Range: "+ range + " Average: " + String.format("%.2f",avg) + " Median: " + String.format("%.2f",med) ;

    }
    
    private static void fillPrimeN(long n) {
        if(n>1){
            primeN.add(Long.valueOf(2));
            for(long i =3; i<=n; i++){
                primeN.add(i);
            }
        }
    }
    
    private static double getAverage(Object[] toArray) {
        double d = 0;
        for (Object toArray1 : toArray) {
            d += (Long) toArray1;
        }
        return d/toArray.length;
    }

    private static double getMedian(Object[] toArray) {
        int s = toArray.length;
        return s%2==0? ((Long) toArray[s/2] + (Long) toArray[((s/2)-1)])/2.0:(Long) toArray[(s/2)];
    }
    
    private static ArrayList<Long> getFinalArrList(long n){
        ArrayList<Long> arrL = new ArrayList<>();
        arrL.clear();
        if(n<=4){
            for(long i=1;i<=n;i++){
                arrL.add(i);
                tMap.put(i, i);
            }
        }
        else{
            arrL = getFinalArrList(n-1);
            ArrayList<Long> helper = new ArrayList<>();
            helper.clear();
            
            if(!tMapHelp.isEmpty()){
                Object[] keys = tMapHelp.keySet().toArray();
                Object[] values = tMapHelp.values().toArray();
                for(int i = 0; i<values.length; i++){
                    if((Long) values[i]<=n){
                        helper.add((Long) keys[i]);
                        tMap.put((Long) keys[i], (Long) values[i]);
                        tMapHelp.remove((Long) keys[i], (Long) values[i]);
                    }
                }
            }
           for(int i = 1; i<arrL.size();i++){
                for(int j = lastArraySize; j<arrL.size();j++){
                    long rr = arrL.get(i)*arrL.get(j);
                    if(!tMap.containsKey(rr)){
                        long gg = tMap.get(arrL.get(i))+tMap.get(arrL.get(j));
                        if(gg<=basicN){
                            if(gg<=n){
                                helper.add(rr);
                                tMap.put(rr, gg);
                            }
                            else{
                                    tMapHelp.put(rr, gg);
                            }
                        }
                    }
                }
            } 
            lastArraySize = arrL.size();
            arrL.addAll(helper);
            
            if(!tMap.containsKey(n)){
                tMap.put(n, n);
                arrL.add(n);
            }
            
        }
        return arrL;
    }
    
}
