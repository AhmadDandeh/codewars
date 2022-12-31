public class RailFenceCipher {
   
    public static String encode(String s, int n) {
        switch (n) {
            case 0:
                return "";
            case 1:
                return s;
            default:
                String[][] arr = new String[n][s.length()];
                int index = 0;
                boolean dir = true;
                for(int i = 0; i<s.length(); i++){
                    arr[index][i] = s.charAt(i)+"";
                    if(dir){
                        if(index + 1 == n){
                            dir = false;
                            index --;
                        }
                        else{
                            index++;
                        }
                    }
                    else{
                        if(index == 0){
                            dir = true;
                            index++;
                        }
                        else{
                            index--;
                        }
                    }
                }
                    
                StringBuilder sb=new StringBuilder();
                for(int i = 0; i<n; i++){
                    for(int j=0; j<s.length(); j++){
                        if(arr[i][j] != null){
                            sb.append(arr[i][j]);
                        }
                    }
                }
                return sb.toString();
        }
    }
    
    public static String decode(String s, int n) {
        switch (n) {
            case 0:
                return "";
            case 1:
                return s;
            default:
                String[][] arr = new String[n][s.length()];
                int index = 0;
                boolean dir = true;
                for(int i = 0; i<s.length(); i++){
                    arr[index][i] = "*";
                    if(dir){
                        if(index + 1 == n){
                            dir = false;
                            index --;
                        }
                        else{
                            index++;
                        }
                    }
                    else{
                        if(index == 0){
                            dir = true;
                            index++;
                        }
                        else{
                            index--;
                        }
                    }
                }
                index = 0;
                for(int i = 0; i<n; i++){
                    for(int j=0; j<s.length(); j++){
                        if("*".equals(arr[i][j])){
                            arr[i][j] = s.charAt(index)+"";
                            index++;
                        }
                    }
                }
                StringBuilder sb=new StringBuilder();
                dir = true;
                index = 0;
                for(int i = 0; i<s.length(); i++){
                    sb.append(arr[index][i]);
                    if(dir){
                        if(index + 1 == n){
                            dir = false;
                            index --;
                        }
                        else{
                            index++;
                        }
                    }
                    else{
                        if(index == 0){
                            dir = true;
                            index++;
                        }
                        else{
                            index--;
                        }
                    }
                }
                return sb.toString();
        }
    }
}
