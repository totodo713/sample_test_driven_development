import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("HelloWorld")
public class HelloWorldTest {
  private HelloWorld target;

  @DisplayName("コンストラクタ")
  @Nested
  public class HelloWorldConstructorTest {

    @DisplayName("デフォルトコンストラクタ")
    @Test
    void executeTest() {
      var actual = new HelloWorld();

      var expected = "class HelloWorld";
      Assertions.assertEquals(expected, actual.getClass().toString());
      expected = "Hello, World!";
      Assertions.assertEquals(expected, actual.getMessage());
    }

    @DisplayName("メッセージ指定コンストラクタ")
    @Test
    void executeTest2() {
      var input = "input";

      var actual = new HelloWorld(input);

      var expected = "class HelloWorld";
      Assertions.assertEquals(expected, actual.getClass().toString());
      expected = input;
      Assertions.assertEquals(expected, actual.getMessage());
    }
  }

  @DisplayName("execute()")
  @Nested
  public class HelloWorldExecuteTest {

    ByteArrayOutputStream out;

    @BeforeEach
    void setup() {
      out = new ByteArrayOutputStream();
      System.setOut(new PrintStream(out));
    }

    @DisplayName("Hello, World!を出力すること")
    @Test
    void executeTest() {
      target = new HelloWorld();
      target.execute();
      var actual = out.toString();
      var expected = "Hello, World!\n";
      Assertions.assertEquals(expected, actual);
    }

    @DisplayName("inputを出力すること")
    @Test
    void executeTest2() {
      var input = "input";
      target = new HelloWorld(input);
      target.execute();
      var actual = out.toString();
      var expected = input + "\n";
      Assertions.assertEquals(expected, actual);
    }
  }
}
