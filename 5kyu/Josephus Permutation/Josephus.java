import java.util.List;
import java.util.ArrayList;

public class Josephus {
  public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
    int index=-1;
    List<T> newItems=new ArrayList<>();
    while(!items.isEmpty()){
      index+=k;
      index%=items.size();
      newItems.add(items.remove(index));
      index--;
    }
    return newItems;
  }
}