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
  @DisplayName("等価性比較")
  public void testEquality() {
    assertEquals(Money.dollar(5), Money.dollar(5));
    assertNotEquals(Money.dollar(5), Money.dollar(6));
    assertEquals(Money.franc(5), Money.franc(5));
    assertNotEquals(Money.franc(5), Money.franc(6));
    assertNotEquals(Money.dollar(5), Money.franc(5));
  }

  @Test
  @DisplayName("掛け算")
  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(5 * 2), five.times(2));
    assertEquals(Money.dollar(5 * 3), five.times(3));
  }

  @Test
  @DisplayName("通貨")
  public void testCurrency() {
    assertEquals("USD", Money.dollar(1).currency());
    assertEquals("CHF", Money.franc(1).currency());
  }

  @Test
  @DisplayName("異なる通貨クラスの等価性")
  public void testDifferentClassEquality(){
    assertEquals(new Money(10, "CHF"), new Franc(10, "CHF"));
  }

  @TestInstance(PER_CLASS)
  @DisplayName("フランテスト")
  @Nested
  class FrancTest {

    @Test
    @DisplayName("掛け算")
    public void testMultiplication() {
      Money five = Money.franc(5);
      assertEquals(Money.franc(5 * 2), five.times(2));
      assertEquals(Money.franc(5 * 3), five.times(3));
    }
  }
}
