class LongestConsec {
    
    public static String longestConsec(String[] strarr, int k) {
        if ((strarr.length <= 0) || (strarr.length < k) || (k <= 0)) {
            return "";
        } 
        else {
            String lWord = "";
            for (int i = 0; i < strarr.length; i++) {
                String newWord = "";
                for (int j = 0; j < k; j++) {
                    if((j+i)==strarr.length)
                        break;
                    newWord += strarr[j + i];
                }
                if (lWord.length() < newWord.length()) {
                    lWord = newWord;
                }
            }
            return lWord;
        }
    }
}