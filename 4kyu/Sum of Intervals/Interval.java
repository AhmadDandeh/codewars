package cw;

import java.util.TreeMap;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        if(intervals == null)
            return 0;
        TreeMap<Integer,Integer> tMap=new TreeMap<>();
        tMap.clear();
        
        for(int[] row:intervals){
            if(row[0] != row[1]){
                if(tMap.containsKey(row[0])){
                    if(row[1]>tMap.get(row[0])){
                        tMap.replace(row[0],row[1]);
                    }
                }
                else{
                    tMap.put(row[0], row[1]);
                }
            }
        }
        
        if(tMap.isEmpty()){
            return 0;
        }
        
        Object[] keys = tMap.keySet().toArray();
        Object[] values = tMap.values().toArray();
        int sum = 0;
        for(int i = 0; i<keys.length-1; i++){
            if((int) values[i] >= (int) keys[i+1]){
                keys[i+1] = keys[i];
                if((int) values[i] > (int) values[i+1]){
                    values[i+1] = values[i];
                }
            }
            else{
                sum += ((int) values[i] - (int) keys[i]);
            }
        }
        sum += ((int) values[keys.length-1] - (int) keys[keys.length-1]);
        return sum;
    }
}