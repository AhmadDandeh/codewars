import java.util.Arrays;
public class FindOdd {
	public static int findIt(int[] a) {
  	String arrS=Arrays.toString(a).replace("["," ").replace("]"," ").replaceAll(",", " ,");
    for(int aNum:a){
      String aNumS=" "+aNum+" ";
      int arrSL=arrS.length();
      arrS=arrS.replaceAll(aNumS, "");
      if(((arrSL-arrS.length())/aNumS.length())%2==1)
        return aNum;
    }
    return -1;
  }
}