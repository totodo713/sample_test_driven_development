package money;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Money")
public class MoneyTest {

  @Test
  @DisplayName("掛け算")
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    five.times(2);
    assertEquals(5 * 2, five.amount);
  }
}
