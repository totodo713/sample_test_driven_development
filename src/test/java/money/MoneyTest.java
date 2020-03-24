package money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@DisplayName("通貨テスト")
public class MoneyTest {

  @Test
  @DisplayName("掛け算")
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    assertEquals(new Dollar(5 * 2), five.times(2));
    assertEquals(new Dollar(5 * 3), five.times(3));
  }

  @Test
  @DisplayName("等価性比較")
  public void testEquality() {
    assertEquals(new Dollar(5), new Dollar(5));
    assertNotEquals(new Dollar(5), new Dollar(6));
  }

  @TestInstance(PER_CLASS)
  @DisplayName("フラン")
  @Nested
  class FrancTest {

    @Test
    @DisplayName("掛け算")
    public void testMultiplication() {
      Franc five = new Franc(5);
      assertEquals(new Franc(5 * 2), five.times(2));
      assertEquals(new Franc(5 * 3), five.times(3));
    }

    @Test
    @DisplayName("等価性比較")
    public void testEquality() {
      assertEquals(new Franc(5), new Franc(5));
      assertNotEquals(new Franc(5), new Franc(6));
    }
  }
}
