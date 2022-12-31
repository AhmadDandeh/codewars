public class CountingDuplicates {
  public static int duplicateCount(String text) {
    // Write your code here
    text=text.toLowerCase();
    char[] chars=new char[text.length()];
    int[] charsRepeat=new int[text.length()];
    int numOfChars=0;
    for(int i=0;i<text.length();i++){
      boolean con=true;
      for(int j=0;j<numOfChars;j++){
        if(chars[j]==text.charAt(i)){
          charsRepeat[j]++;
          con=false;
          break;
        }
      }
      if(con){
        chars[numOfChars]=text.charAt(i);
        charsRepeat[numOfChars]++;
        numOfChars++;
      }
    }
    int count=0;
    for(int i=0;i<numOfChars;i++){
      if(charsRepeat[i]>1){
        count++;
      }
    }
    return count;
  }
}