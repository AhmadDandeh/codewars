import org.apache.commons.lang3.StringUtils;

public class Dictionary {
  
  private final String[] words;

  public Dictionary(String[] words) {
    this.words = words;
  }
  
  public String findMostSimilar(String to) {
  int check = 0;
  String temp = "";
    for (int i = 0; i < words.length; i++) {
      int gdl = StringUtils.getLevenshteinDistance(to, words[i]);
      if ((10 - gdl) > check) {
        check = (10 - gdl);
         temp = words[i];
         }
       }
    return temp;
  }
}