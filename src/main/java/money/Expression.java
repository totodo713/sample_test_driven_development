package money;

interface Expression {
  Money exchange(Bank bank, String to);
}
