class MiddlePermutation {
    
    public static String findMidPerm(String strng) {
        if(strng.isEmpty()){
            return "";
        }
        else if(strng.length() == 1){
            return strng;
        }
        else if(strng.length() == 2){
            return sortStringASC(strng);
        }
        else{
            strng = sortStringASC(strng);
            int stringL = strng.length();
            String result = "";
            if(stringL%2 ==0){
                return strng.charAt(stringL/2-1)+sortStringDESC(strng.substring(0, stringL/2-1)+strng.substring((stringL/2)));
            }
            else{
                return strng.charAt(stringL/2) + findMidPerm(strng.substring(0, stringL/2)+strng.substring((stringL/2)+1));
            }
        }
    }
    
    private static String sortStringASC(String s){
        char[] toCharArray = s.toCharArray();
        for(int i = 0; i<toCharArray.length-1; i++){
            for(int j = i+1; j<toCharArray.length; j++){
                if(toCharArray[i]>toCharArray[j]){
                    char c = toCharArray[i];
                    toCharArray[i] = toCharArray[j];
                    toCharArray[j] = c;
                }
            }
        }
        String res = "";
        for(int i = 0; i<toCharArray.length; i++){
            res += toCharArray[i];
        }
        return res;
    }
    
    private static String sortStringDESC(String s){
        char[] toCharArray = s.toCharArray();
        for(int i = 0; i<toCharArray.length-1; i++){
            for(int j = i+1; j<toCharArray.length; j++){
                if(toCharArray[i]<toCharArray[j]){
                    char c = toCharArray[i];
                    toCharArray[i] = toCharArray[j];
                    toCharArray[j] = c;
                }
            }
        }
        String res = "";
        for(int i = 0; i<toCharArray.length; i++){
            res += toCharArray[i];
        }
        return res;
    }
 
}