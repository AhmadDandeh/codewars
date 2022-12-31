import java.util.ArrayList;
public class DirReduction {
  public static String[] dirReduc(String[] arr) {
    ArrayList<String> arrL = new ArrayList<>();
    for (String s : arr) {
      arrL.add(s);
    }
    boolean change = true;
    while (change) {
      change = false;
      for (int i = 0; i < arrL.size() - 1; i++) {
        if (("NORTH".equals(arrL.get(i)) && "SOUTH".equals(arrL.get(i + 1))) || ("SOUTH".equals(arrL.get(i)) && "NORTH".equals(arrL.get(i + 1))) || ("EAST".equals(arrL.get(i)) && "WEST".equals(arrL.get(i + 1))) || ("WEST".equals(arrL.get(i)) && "EAST".equals(arrL.get(i+1)))) {
          arrL.remove(i + 1);
          arrL.remove(i);
          i--;
          change = true;
        }
      }
    }
    
    String[] result = new String[arrL.size()];
    for (int i = 0; i < arrL.size(); i++) {
      result[i] = arrL.get(i);
    }
    return result;
  }
}