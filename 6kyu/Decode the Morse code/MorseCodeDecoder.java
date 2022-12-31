public class MorseCodeDecoder {
    public static String decode(String morseCode) {
      String result="";
      for(String word:morseCode.trim().split("   ")){
        for(String c:word.split(" ")){
          result+=MorseCode.get(c);
        }
        result+=" ";
      }
      return result.trim();
    }
}