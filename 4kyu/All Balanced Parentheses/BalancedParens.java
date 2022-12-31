import java.util.ArrayList;
import java.util.List;

public class BalancedParens {
        private static List<String> res = new ArrayList<>();
    
    public static void generate(int n, int numOPEN, int numCLOSE, String s){
        if(s.length()== n*2){
            res.add(s);
        }
        else{
            if(numCLOSE<n && numCLOSE<numOPEN){
                generate(n, numOPEN, numCLOSE+1, s+")");
            }
            if(numOPEN<n){
                generate(n, numOPEN+1, numCLOSE, s+"(");
            }
        }
    }
    
    public static List <String> balancedParens (int n) {
        res.clear();
        generate(n, 0, 0, "");
        return res;
    }
}