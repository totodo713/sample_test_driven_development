package money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("通貨テスト")
public class MoneyTest {

  @Test
  @DisplayName("等価性比較")
  public void testEquality() {
    assertEquals(Money.dollar(5), Money.dollar(5));
    assertNotEquals(Money.dollar(5), Money.dollar(6));
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
  @DisplayName("単純な足し算")
  public void testSimpleAdditon() {
    Money five = Money.dollar(5);
    Expression sum = five.plus(five);
    Bank bank = new Bank();
    Money exchanged = bank.exchange(sum, "USD");
    assertEquals(Money.dollar(10), exchanged);
  }

  @Test
  @DisplayName("plus()がSumインスタンスを返す")
  public void testPlusReturnSum() {
    Money five = Money.dollar(5);
    Expression result = five.plus(five);
    Sum sum = (Sum) result;
    assertEquals(five, sum.augend);
    assertEquals(five, sum.addend);
  }

  @Test
  @DisplayName("Sumの換算")
  public void testExchangeSum() {
    Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
    Bank bank = new Bank();
    Money result = bank.exchange(sum, "USD");
    assertEquals(Money.dollar(7), result);
  }

  @Test
  @DisplayName("Moneyの換算")
  public void testExchangeMoney() {
    Bank bank = new Bank();
    Money result = bank.exchange(Money.dollar(1), "USD");
    assertEquals(Money.dollar(1), result);
  }
}
