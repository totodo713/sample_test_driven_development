package money;

class Money implements Expression {
  protected int amount;
  protected String currency;

  Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  @Override
  public boolean equals(Object obj) {
    Money money = (Money) obj;
    return amount == money.amount && currency.equals(money.currency);
  }

  Expression times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }

  String currency() {
    return currency;
  }

  @Override
  public String toString() {
    return amount + " " + currency;
  }

  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

  public Money exchange(Bank bank, String to) {
    return new Money(amount / bank.rate(currency, to), to);
  }
}
