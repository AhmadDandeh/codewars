import java.util.HashMap;
public class Parser {    
  public static int parseInt(String numStr) {
    HashMap<String, Integer> hashMap=new HashMap<>();
    hashMap.put("zero", 0);
    hashMap.put("one", 1);
    hashMap.put("two", 2);
    hashMap.put("three", 3);
    hashMap.put("four", 4);
    hashMap.put("five", 5);
    hashMap.put("six", 6);
    hashMap.put("seven", 7);
    hashMap.put("eight", 8);
    hashMap.put("nine", 9);
    hashMap.put("ten", 10);
    hashMap.put("eleven", 11);
    hashMap.put("twelve", 12);
    hashMap.put("thirteen", 13);
    hashMap.put("fourteen", 14);
    hashMap.put("fifteen", 15);
    hashMap.put("sixteen", 16);
    hashMap.put("seventeen", 17);
    hashMap.put("eighteen", 18);
    hashMap.put("nineteen", 19);
    hashMap.put("twenty", 20);
    hashMap.put("thirty", 30);
    hashMap.put("forty", 40);
    hashMap.put("fifty", 50);
    hashMap.put("sixty", 60);
    hashMap.put("seventy", 70);
    hashMap.put("eighty", 80);
    hashMap.put("ninety", 90);
    hashMap.put("hundred", 100);
    hashMap.put("thousand", 1000);
    hashMap.put("million", 1000000);
        
    int num=0;
    String[] split = numStr.split(" ");
    for(String s:split){
      if(s.equals("and")){
        continue;
      }
      else if(s.contains("-")){
        num+=(hashMap.get(s.substring(0,s.indexOf("-")))+hashMap.get(s.substring(s.indexOf("-")+1)));
      }
      else{
        int number=hashMap.get(s);
        if(number==100){
          int mod=num%10;
          num+=(mod*100-mod);
        }
        else if(number==1000){
          int mod=num%1000;
          num+=(mod*1000-mod);
        }
        else if(number==1000000){
          int mod=num%1000000;
          num+=(mod*1000000-mod);
        }
        else{
          num+=number;
        }
      }
    }
    return num;
  }
}