import java.util.List;
import java.util.ArrayList;

class Permutations {
    
    private static List<String> result;
    public static List<String> singlePermutations(String s) {
        result = new ArrayList<>();
        result.clear();
        if(s.isEmpty())
            return result;
        
        singlePermutationsDFS(s, "");
        return result;
    }
    
    private static void singlePermutationsDFS(String s, String res){
        if(s.isEmpty()){
            result.add(res);
        }
        else{
            ArrayList<String> chars = new ArrayList<>();
            chars.clear();
            
            for(int i = 0; i<s.length(); i++){
                if(!chars.contains(s.charAt(i)+"")){
                    chars.add(s.charAt(i)+"");
                    singlePermutationsDFS(s.substring(0, i)+s.substring(i+1), res+s.charAt(i));
                }
            }
        }
    }
}