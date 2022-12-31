import java.util.HashMap;
public class HexToRGB {
 
    public static String convertToBinary(String s){
        HashMap<String,String> hMap=new HashMap<>();
        hMap.clear();
        hMap.put("0", "0000");
        hMap.put("1", "0001");
        hMap.put("2", "0010");
        hMap.put("3", "0011");
        hMap.put("4", "0100");
        hMap.put("5", "0101");
        hMap.put("6", "0110");
        hMap.put("7", "0111");
        hMap.put("8", "1000");
        hMap.put("9", "1001");
        hMap.put("a", "1010");
        hMap.put("b", "1011");
        hMap.put("c", "1100");
        hMap.put("d", "1101");
        hMap.put("e", "1110");
        hMap.put("f", "1111");
        s=s.toLowerCase();
        String res="";
        for(int i=0;i<2;i++){
            res+=hMap.get(s.charAt(i)+"");
        }
        return res;
    }
    public static int getHexValue(String s){
        int x=0;
        for(int i=7;i>=0;i--){
            if(s.charAt(i)=='1'){
                x+=Math.pow(2, 7-i);
            }
        }
        return x;
    }
    public static int[] hexStringToRGB(String hex){
        return new int[]{getHexValue(convertToBinary(hex.substring(1, 3))),getHexValue(convertToBinary(hex.substring(3, 5))),getHexValue(convertToBinary(hex.substring(5, 7)))};
    }
  
}