class Kata {
  public static String getMiddle(String word) {
        return (word.length()%2==0?word.charAt(word.length()/2-1)+"":"")+word.charAt(word.length()/2);
  }
}