public class Kata {
public static String convNumToBase3String(int n){
        String result = "";
        while (n > 0) {
            result += (n % 3);
            n /= 3;
        }
        return result;
    }

    public static int[] convertStringToArray(String s){
        int[] arr = new int[s.length()];
        for(int i = 0; i<s.length();i++){
            arr[i] = Integer.parseInt(s.charAt(i)+"");
        }
        return arr;
    }
    
    private static char int_2_char(int i) {
        switch (i) {
            case 0:
                return 'R';
            case 1:
                return 'G';
            case 2:
                return 'B';

            // shouldn't happen
            default:
                return '\0';
        }
    }

    private static int char_2_int(char c) {
        switch (c) {
            case 'R':
                return 0;
            case 'G':
                return 1;
            case 'B':
                return 2;

            // shouldn't happen
            default:
                return 3;
        }
    }

    private static int binom_max_2(int n, int k){
        if (n < k)
            return 0;
        switch (n){
            case 0: case 1:
                return 1;
            case 2:
                return 1 + ((k == 1)?1:0);

            // shouldn't happen
            default:
                return 0;
        }
    }

    private static int lucas_3(int lenN, int[] nArr,int lenK, int[] kArr){   
        int prod = 1;
        for (int i = 0; i < lenN; i++) {
            int n_i = nArr[i];
            int k_i = (i < lenK) ? kArr[i] : 0;
            prod = (prod * binom_max_2(n_i, k_i)) % 3;
        }
        return prod % 3;
    }
    
    public static char triangle(final String row) {
        int sum = 0;
        final int n = row.length();
        String numBase3Str = convNumToBase3String(n-1);
        int lenNumBase3 = numBase3Str.length();
        int[] nArray = convertStringToArray(numBase3Str);
        
        for (int km1 = 0; km1 < n; km1++){
            String kBase3Str = convNumToBase3String(km1);
            int kLen = kBase3Str.length();
            int[] kArray = convertStringToArray(kBase3Str);
            
            int Cnk_mod3 = lucas_3(lenNumBase3, nArray, kLen, kArray);

            sum = (sum + Cnk_mod3 * char_2_int(row.charAt(km1))) % 3;
        }
        
        int sign = (n % 2) * 2 - 1;

        int sum_mod3 = (3 + (sign * (int)(sum % 3))) % 3;
        return int_2_char(sum_mod3);
    }  
}