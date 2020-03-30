package money;

class Sum implements Expression {
  Expression addend;
  Expression augend;

  Sum(Expression addend, Expression augend) {
    this.addend = addend;
    this.augend = augend;
  }

  public Money exchange(Bank bank, String to) {
    int amount = augend.exchange(bank, to).amount + addend.exchange(bank, to).amount;
    return new Money(amount, to);
  }

  @Override
  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

  public Expression times(int multiplier) {
    return new Sum(augend.times(multiplier), addend.times(multiplier));
  }
}
