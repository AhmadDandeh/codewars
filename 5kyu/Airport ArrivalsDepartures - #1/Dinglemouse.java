class Dinglemouse {
  
  private static final String ALPHABET = Preloaded.ALPHABET;
  public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
        for(int i=0;i<lines.length;i++){
            for(int j=0;j<lines[i].length();j++){
                for(int k=j;k<lines[i].length();k++){
                    char c=ALPHABET.charAt((ALPHABET.indexOf(lines[i].charAt(k))+rotors[i][j])%ALPHABET.length());
                    lines[i]=lines[i].substring(0, k)+c+lines[i].substring(k+1);
                }
            }
        }
        return lines;
    }  
} 