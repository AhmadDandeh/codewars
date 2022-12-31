import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PickPeaks {
    
       
        public static Map<String,List<Integer>> getPeaks(int[] arr) {
        Map<String,List<Integer>> hMap=new HashMap<>();
        hMap.clear();
        hMap.put("pos", new ArrayList<>());
        hMap.put("peaks", new ArrayList<>());
        
        for(int i=1;i<arr.length-1;i++){
          if(arr[i]>arr[i-1]){
            if(arr[i]>arr[i+1]){
              hMap.get("pos").add(i);
              hMap.get("peaks").add(arr[i]);
            }
            else if(arr[i]==arr[i+1]){
              int ii=i;
              while(arr[i]==arr[ii+1]){
                if(ii!=arr.length-2){
                    ii++;
                }
                else{
                    break;
                }
              }
              if(arr[i]>arr[ii+1]){
                hMap.get("pos").add(i);
                hMap.get("peaks").add(arr[i]);
              }
              i=ii-1;
            }
          }
        }
        return hMap;
    }

}