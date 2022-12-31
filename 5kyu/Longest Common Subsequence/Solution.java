public class Solution {
    private static String resultF="";
    private static boolean findAllChars(String word, String search){
        int index=-1;
        for(int i=0;i<word.length();i++){
            int ind=search.indexOf(""+word.charAt(i), index+1);
            if(ind==-1){
                return false;
            }
            else{
                index=ind;
            }
        }
        return true;
    }
    private static boolean getWord(int levelBasic, int levelNow, int indexW, String word, String search, String res){
        if(levelBasic==levelNow){
            if(findAllChars(res, search)){
                resultF=res;
                return true;
            }
        }
        else{
            for(int i=indexW;i<=word.length()-levelBasic+levelNow;i++){
                boolean breakW=getWord(levelBasic, levelNow+1, i+1, word, search, res+word.charAt(i));
                if(breakW){
                    return breakW;
                }
            }
        }
        return false;
    }    
    public static String lcs(String x, String y) {
      System.out.println(x+"   "+y);
      resultF="";
        for(int i=y.length();i>0;i--){
            if(getWord(i, 0, 0, y, x, ""))
                break;
        }
        return resultF;
    }
    
}