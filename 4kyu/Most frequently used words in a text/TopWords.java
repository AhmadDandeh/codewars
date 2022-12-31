import java.util.ArrayList;
import java.util.List;

public class TopWords {
    
    public static List<String> top3(String s) {
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(((int) s.charAt(i)<97)||((int)s.charAt(i)>122)){
                if(s.charAt(i)!='\''){
                    s=s.replace(s.charAt(i)+"", " ");
                }
            }
        }
      for(int i=0;i<s.length();i++){
            
                if((s.charAt(i)=='\'')&&((s.charAt(i-1)==' ')||(s.charAt(i-1)=='\''))&&((s.charAt(i+1)==' ')||(s.charAt(i+1)=='\''))){
                  
                    s=s.replace(s.charAt(i)+"", " ");
                }
            
        }
        s=s.trim();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(s.charAt(i-1)==' '){
                    s=s.substring(0,i)+s.substring(i+1);
                    i--;
                }
            }
        }
        String[] words=new String[3];
        words[0]=words[1]=words[2]="";
        int[] occs=new int[3];
        occs[0]=occs[1]=occs[2]=0;
        while(!s.isEmpty()){
            s=" "+s+" ";
            int index=s.indexOf(" ",1);
            String word=s.substring(0, index+1);
            boolean change=true;
            int occ=0;
            while(change){
                s=s.replaceFirst(word, " ");
                occ++;
                if(!s.contains(word)){
                    change=false;
                }
            }
             
                if(occ>occs[0]){
                    occs[2]=occs[1];
                    occs[1]=occs[0];
                    occs[0]=occ;
                    words[2]=words[1];
                    words[1]=words[0];
                    words[0]=word.trim();
                }
                else if(occ>occs[1]){
                    occs[2]=occs[1];
                    occs[1]=occ;
                    words[2]=words[1];
                    words[1]=word.trim();
                }
                else if(occ>occs[2]){
                    occs[2]=occ;
                    words[2]=word.trim();
                }
            
            s=s.trim();
        }
        
      List<String> ll=new ArrayList<>();
        if(occs[0]==0){
            return ll;
        }
        else{
            for(int i=0;i<3;i++){
                if(occs[i]==0){
                    break;
                }
                else{
                    ll.add(words[i]);
                }
            }
            return ll;
        }
    }
}