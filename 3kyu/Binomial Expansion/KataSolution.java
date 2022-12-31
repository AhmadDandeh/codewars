import java.util.ArrayList;

public class KataSolution {
public static String expand(String expr) {
        int indexPow = expr.lastIndexOf("^");
        int pow = Integer.parseInt(expr.substring(indexPow+1));
        if(pow == 0){
            return "1";
        }
        else{
            expr = getExprWithoutPower(expr, indexPow);
            if(pow == 1){
                return expr;
            }
            else{
                // spilt strings
                int indexP = expr.lastIndexOf("+");
                int secondIndex = indexP>-1?indexP:expr.lastIndexOf("-");
                
                String firstExpr = expr.substring(0, secondIndex);
                String secondExpr = expr.substring(secondIndex);
                
                char charBasic = firstExpr.charAt(secondIndex-1);
                firstExpr = firstExpr.substring(0, secondIndex-1);
                
                long firstInt;
                if("-".equals(firstExpr)){
                    firstInt = -1;
                }
                else{
                    firstInt = firstExpr.isEmpty()?1:Long.parseLong(firstExpr);
                }
                
                long secondInt = Long.parseLong(secondExpr);
                
                if(firstInt == 0 && secondInt == 0){
                    return "0";
                }
                else if(firstInt == 0){
                    return secondInt+"^"+pow;
                }
                else if(secondInt == 0){
                    firstInt = (long) Math.pow(firstInt, pow);
                    return (firstInt==1?"":firstInt+"")+charBasic+"^"+pow;
                }
                else{
                    // spilt numbers and power into ArrayList
                    ArrayList<long[]> basicExprs = new ArrayList<>();// [1]: number positive/negative ___ [1]: power
                    basicExprs.clear();
                    basicExprs.add(new long[]{firstInt,1});
                    basicExprs.add(new long[]{secondInt,0});

                    ArrayList<long[]> result = new ArrayList<>();
                    result.clear();
                    result.addAll(basicExprs);
                    for(int i = 1; i<pow;i++){
                        result = mulExpr(result, basicExprs);
                    }
                    
                    return getStringFromResult(result, charBasic);
                }
            }
        }
    }
    
    private static String getExprWithoutPower(String expr, int indexPow){
        return expr.substring(1, indexPow-1);
    }
    
    private static ArrayList<long[]> mulExpr(ArrayList<long[]> arrL1, ArrayList<long[]> arrL2){
        ArrayList<long[] > res = new ArrayList<>();
        res.clear();
        for (long[] arrL11 : arrL1) {
            for (long[] arrL21 : arrL2) {
                res.add(new long[]{arrL11[0]*arrL21[0],arrL11[1]+arrL21[1]});
            }
        }
        
        for(int i=0; i<res.size()-1; i++){
            for(int j=i+1; j<res.size(); j++){
                if(res.get(i)[1] == res.get(j)[1]){
                    res.get(i)[0] = res.get(i)[0] + res.get(j)[0];
                    res.remove(j);
                    j--;
                }
            }
        }
        return res;
    }

    private static String getStringFromResult(ArrayList<long[]> result, char charBasic) {
        String resultString = "";
        if(result.get(0)[0]==1){
            resultString +=(charBasic+"^"+result.get(0)[1]);
        }
        else if(result.get(0)[0]==-1){
            resultString +=("-"+charBasic+"^"+result.get(0)[1]);
        }
        else{
            resultString +=(result.get(0)[0]+""+charBasic+"^"+result.get(0)[1]);
        }
        
        for(int i=1; i<result.size()-2; i++){
            if(result.get(i)[0]==1){
                resultString +=("+"+charBasic+"^"+result.get(i)[1]);
            }
            else if(result.get(i)[0]==-1){
                resultString +=("-"+charBasic+"^"+result.get(0)[1]);
            }
            else{
                resultString +=((result.get(i)[0]>0?"+":"")+result.get(i)[0]+""+charBasic+"^"+result.get(i)[1]);
            }
        }
        
        resultString += ((result.get(result.size()-2)[0]>0?"+":"")+result.get(result.size()-2)[0]+""+charBasic);
        resultString += ((result.get(result.size()-1)[0]>0?"+":"")+result.get(result.size()-1)[0]);
        return resultString;
    }

}