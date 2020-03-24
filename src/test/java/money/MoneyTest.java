package money;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("通貨テスト")
public class MoneyTest {

  @Test
  @DisplayName("掛け算")
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    Dollar actual = five.times(2);
    assertEquals(5 * 2, actual.amount);
    actual = five.times(3);
    assertEquals(5 * 3, actual.amount);
  }
}
