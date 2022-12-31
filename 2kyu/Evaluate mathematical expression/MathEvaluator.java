public class MathEvaluator {
    public double calculate(String expression) {
        //System.out.println("Original: .............."+expression);
        expression = removeSpace(expression);
        //System.out.println("Remove Space: .........."+expression);
        expression = mergeMarks(expression);
        //System.out.println("Merge Marks: ..........."+expression);
        int openIndex = expression.indexOf("(", 0);
        int closeIndex = -1;
        while(openIndex>=0){
            //System.out.println("Find () manipulate ...");
            closeIndex = getCloseIndex(expression, openIndex);
            expression = getSubCalculate(expression, openIndex, closeIndex);
            openIndex = expression.indexOf("(", openIndex+1);
        }
        
        //System.out.println("After () manipulate: ..."+expression);
        
        expression = opMulDiv(expression);
        //System.out.println("After */ manipulate: ..."+expression);
        expression = mergeMarks(expression);
        //System.out.println("Merge Marks: ..........."+expression);
        
        return opAddSub(expression);
    }
    
    private String getSubCalculate(String input, int openIndex, int closeIndex){
        input = input.substring(0, openIndex)+calculate(input.substring(openIndex+1, closeIndex))+input.substring(closeIndex+1);
        input = mergeMarks(input);
        if(openIndex>0){
            if(input.charAt(openIndex) == '-'){
                if(input.charAt(openIndex-1) == '+'){
                    input = input.substring(0, openIndex-1)+"-"+input.substring(closeIndex+1);
                }
                else if(input.charAt(openIndex-1) == '-'){
                    input = input.substring(0, openIndex-1)+"+"+input.substring(closeIndex+1);
                }
            }
            else if(input.charAt(openIndex) == '+'){
                if(input.charAt(openIndex-1) == '+'){                
                    input = input.substring(0, openIndex-1)+"+"+input.substring(closeIndex+1);
                }
                else if(input.charAt(openIndex-1) == '-'){
                    input = input.substring(0, openIndex-1)+"-"+input.substring(closeIndex+1);
                }
            }
        }
        return input;
    }
    
    private int getCloseIndex(String input, int openIndex){
        int ocN = 1;
        for(int i = openIndex+1; i<input.length();i++){
            if(input.charAt(i)=='('){
                ocN++;
            }
            else if(input.charAt(i)==')'){
                ocN--;
            }
            
            if(ocN == 0){
                return i;
            }
        }
        return 0;
    }
    
    private String mergeMarks(String input){
        for(int i = 0; i<input.length();i++){
            if(input.charAt(i)== '-'){
                if(input.charAt(i+1) == '-'){
                    input = input.substring(0, i) + "+" + input.substring(i+2);
                    i--;
                }
                else if(input.charAt(i+1) == '+'){
                    input = input.substring(0, i) + "-" + input.substring(i+2);
                    i--;
                }
            }
            else if(input.charAt(i)== '+'){
                if(input.charAt(i+1) == '-'){
                    input = input.substring(0, i) + "-" + input.substring(i+2);
                    i--;
                }
                else if(input.charAt(i+1) == '+'){
                    input = input.substring(0, i) + "+" + input.substring(i+2);
                    i--;
                }
            }
        }
        return input;
    }
    
    private String removeSpace(String input){
        return input.replaceAll(" ", "");
    }

    private String opMulDiv(String expression) {
        // find index *,/ and choose the smallest index
        int indexMul = expression.indexOf("*");
        int indexDiv = expression.indexOf("/");
        while((indexMul != -1)||(indexDiv != -1)){
            boolean op = findOperationType(indexMul, indexDiv); // True = Mul, False = Div
            int minIndex = -1;
            if(op){
                minIndex = indexMul;
            }
            else{
                minIndex = indexDiv;
            }
            
            int prevIndexNum = findPrevNum(expression.substring(0, minIndex));
            int nextIndexNum = findNextNum(expression.substring(minIndex+1));
            int start = prevIndexNum+1;
            int end = (nextIndexNum == -1)?expression.length():nextIndexNum+minIndex+1;
            System.out.println(prevIndexNum+":"+minIndex+":"+nextIndexNum);
            String newS = "";
            if(op){
                double s = Double.parseDouble(expression.substring(start,minIndex))*Double.parseDouble(expression.substring(minIndex+1,end));
                newS += s;
            }
            else{
                double s = Double.parseDouble(expression.substring(start,minIndex))/Double.parseDouble(expression.substring(minIndex+1,end));
                newS += s;
            }
            expression = expression.replace(expression.substring(start, end), newS);
            indexMul = expression.indexOf("*");
            indexDiv = expression.indexOf("/");
        }
        return expression;
    }

    private double opAddSub(String expression) {
        int indexAdd = expression.indexOf("+",1);
        int indexSub = expression.indexOf("-",1);
        double result = 0;
        while((indexAdd != -1)||(indexSub != -1)){
            boolean op = findOperationType(indexAdd, indexSub); // True = Add, False = Sub
            int minIndex = -1;
            if(op){
                minIndex = indexAdd;
            }
            else{
                minIndex = indexSub;
            }
            result += Double.parseDouble(expression.substring(0, minIndex));
            expression = expression.substring(minIndex);
            indexAdd = expression.indexOf("+",1);
            indexSub = expression.indexOf("-",1);
        }
        result += Double.parseDouble(expression);
        //System.out.println("Res: "+result);
        return result;
    }

    private boolean findOperationType(int indexMul, int indexDiv) {
        // True = Mul, False = Div
        if(indexMul == -1){
            return false;
        }
        else if(indexDiv == -1){
            return true;
        }
        else{
            return indexMul<indexDiv;  
        }
    }

    private int findPrevNum(String substring) {
        int indexA = substring.lastIndexOf("+");
        int indexS = substring.lastIndexOf("-");
        
        return (indexA>indexS)?indexA:indexS;
        
    }

    private int findNextNum(String substring) {
        int indexA = substring.indexOf("+",1);
        int indexS = substring.indexOf("-",1);
        int indexM = substring.indexOf("*",1);
        int indexD = substring.indexOf("/",1);
        
        if((indexA == indexS)&&(indexA == indexM)&&(indexA == indexD)){
            return -1;
        }
        else{
            if(indexA == -1)
                indexA = Integer.MAX_VALUE;
            if(indexS == -1)
                indexS = Integer.MAX_VALUE;
            if(indexM == -1)
                indexM = Integer.MAX_VALUE;
            if(indexD == -1)
                indexD = Integer.MAX_VALUE;
            return (indexA<indexS)?((indexA<indexM)?((indexA<indexD)?indexA:indexD):((indexM<indexD)?indexM:indexD)):((indexS<indexM)?((indexS<indexD)?indexS:indexD):((indexM<indexD)?indexM:indexD));
        }
    }

}