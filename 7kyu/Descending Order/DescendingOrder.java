public class DescendingOrder {
  public static int sortDesc(final int num) {
    String result="",numS=num+"";
        for(int i=9;i>-1;i--){
            String numSAR=numS.replaceAll(i+"","");
            for(int j=0;j<(numS.length()-numSAR.length());j++){
                result+=i;
            }
        }
        return Integer.parseInt(result);
  }
}