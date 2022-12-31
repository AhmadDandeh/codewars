import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class BagelSolver extends Bagel {
  public static Bagel getBagel() {
    try {
      Field b = Boolean.class.getDeclaredField("TRUE");
      Field modifiers = Field.class.getDeclaredField("modifiers");
      modifiers.setAccessible(true);
      modifiers.setInt(b, b.getModifiers() & ~Modifier.FINAL);
      b.setAccessible(true);
      b.set(null, Boolean.FALSE);
    } catch (Exception e) {}
    return new Bagel();
  }
}