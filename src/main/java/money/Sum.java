package money;

class Sum implements Expression {
  Money addend;
  Money augend;

  Sum(Money addend, Money augend) {
    this.addend = addend;
    this.augend = augend;
  }

  public Money exchange(Bank bank, String to) {
    int amount = augend.amount + addend.amount;
    return new Money(amount, to);
  }
}
