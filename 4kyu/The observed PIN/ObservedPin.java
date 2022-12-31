import java.util.List;
import java.util.ArrayList;

public class ObservedPin {

    private static ArrayList<ArrayList<Integer>> values = new ArrayList<>();
    
    public static List<String> getPINs(String observed){
        List<String> result = new ArrayList<>();
        result.clear();
        if(!observed.isEmpty()){
            initValues();
            for(int i = 0; i<observed.length(); i++){
                result = addNextPoss(result, Integer.parseInt(observed.charAt(i)+""));
            }
        }
        return result;
    }

    private static List<String> addNextPoss(List<String> lastResult, int number) {
        List<String> nextResult = new ArrayList<>();
        nextResult.clear();
        if(lastResult.isEmpty()){
            for (Integer get : values.get(number)) {
                nextResult.add(""+get);
            }
        }
        else{
            for(String s: lastResult){
                for (Integer get : values.get(number)) {
                    nextResult.add(s+get);
                }
            }
        }
        return nextResult;
    }

    private static void initValues() {
        values.clear();
        ArrayList<Integer> val0 = new ArrayList<>();
        ArrayList<Integer> val1 = new ArrayList<>();
        ArrayList<Integer> val2 = new ArrayList<>();
        ArrayList<Integer> val3 = new ArrayList<>();
        ArrayList<Integer> val4 = new ArrayList<>();
        ArrayList<Integer> val5 = new ArrayList<>();
        ArrayList<Integer> val6 = new ArrayList<>();
        ArrayList<Integer> val7 = new ArrayList<>();
        ArrayList<Integer> val8 = new ArrayList<>();
        ArrayList<Integer> val9 = new ArrayList<>();
        val0.add(0); val0.add(8); values.add(val0); // 0
        val1.add(1); val1.add(2); val1.add(4); values.add(val1); // 1
        val2.add(1); val2.add(2); val2.add(3); val2.add(5); values.add(val2); // 2
        val3.add(2); val3.add(3); val3.add(6); values.add(val3); // 3
        val4.add(1); val4.add(4); val4.add(5); val4.add(7); values.add(val4); // 4
        val5.add(2); val5.add(4); val5.add(5); val5.add(6); val5.add(8); values.add(val5); // 5
        val6.add(3); val6.add(5); val6.add(6); val6.add(9); values.add(val6); // 6
        val7.add(4); val7.add(7); val7.add(8); values.add(val7); // 7
        val8.add(0); val8.add(5); val8.add(7); val8.add(8); val8.add(9); values.add(val8); // 8
        val9.add(6); val9.add(8); val9.add(9); values.add(val9); // 9
        
    }
    

}