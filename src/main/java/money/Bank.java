package money;

class Bank {

  Money exchange(Expression source, String to) {
    return source.exchange(to);
  }
}
