package money;

import java.util.Objects;

public class Pair {
  private String from;
  private String to;

  Pair(String from, String to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean equals(Object object) {
    Pair pair = (Pair) object;
    return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
