public class BurrowsWheeler {
    
    public static BWT encode(String s) {
        String[] words = new String[s.length()];
        for(int i=0;i<s.length();i++){
            words[i] = s.substring(s.length()-i)+s.substring(0, s.length()-i);
        }
        
        for(int i=0;i<words.length-1;i++){
            for(int j=i;j<words.length;j++){
                if(smallerThan(words[j],words[i])){
                    String k=words[i];
                    words[i]=words[j];
                    words[j]=k;
                }
            }
        }
        
        int indexRes=-1;
        String result="";
        for(int i=0;i<words.length;i++){
            if(words[i].equals(s))
                indexRes=i;
            result+=words[i].charAt(s.length()-1);
        }
        return new BWT(result, indexRes);
    }
    
    private static boolean smallerThan(String word1, String word2) {
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)<word2.charAt(i)){
                return true;
            }
            else if(word1.charAt(i)>word2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static String decode(String s, int n) {
      if(s.isEmpty() || n==-1){
        return "";
      }
        // get the first col as string
        String fS=s;
        for(int i=0; i<fS.length()-1;i++){
            for(int j=i; j<fS.length();j++){
                if(fS.charAt(i)>fS.charAt(j)){
                    fS=fS.substring(0, i)+fS.charAt(j)+fS.substring(i+1, j)+fS.charAt(i)+fS.substring(j+1);
                }
            }
        }
        
        String result="";
        char c = fS.charAt(n);
        result+=c;
        int count = findCharBefore(fS,c,n);
        for(int i=1; i<s.length();i++){
            int index = findIndex(s,c,count);
            c = fS.charAt(index);
            result+=c;
            count = findCharBefore(fS,c,index);
        }
        return result;
    }
   
    private static int findCharBefore(String fS, char c, int n) {
        int count = 0;
        for(int i=0;i<n;i++){
            if(fS.charAt(i)==c)
                count++;
        }
        return count;
    }

    private static int findIndex(String s, char c, int count) {
        int index = -1;
        for(int i=0;i<s.length();i++){
            if(count==0){
                break;
            }
            if(s.charAt(i)==c){
                count--;
                index = i;
            }
        }
        return s.indexOf(c, index+1);
    }
}