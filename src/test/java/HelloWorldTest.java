import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("HelloWorld")
class HelloWorldTest {
  private HelloWorld target;

  @TestInstance(PER_CLASS)
  @DisplayName("コンストラクタ")
  @Nested
  class HelloWorldConstructorTest {

    @DisplayName("デフォルトコンストラクタ")
    @Test
    void executeTest() {
      var actual = new HelloWorld();

      var expected = "class HelloWorld";
      assertEquals(expected, actual.getClass().toString());
      expected = "Hello, World!";
      assertEquals(expected, actual.getMessage());
    }

    @DisplayName("メッセージ指定コンストラクタ")
    @ParameterizedTest
    @MethodSource("inputAndMessageProvider")
    void executeTest2(String input, String message) {
      var actual = new HelloWorld(input);

      var expected = "class HelloWorld";
      assertEquals(expected, actual.getClass().toString());
      expected = message;
      assertEquals(expected, actual.getMessage());
    }

    Stream<Arguments> inputAndMessageProvider() {
      return Stream.of(Arguments.of(null, null), Arguments.of("input", "input"));
    }
  }

  @DisplayName("execute()")
  @Nested
  class HelloWorldExecuteTest {

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
      assertEquals(expected, actual);
    }

    @DisplayName("inputを出力すること")
    @Test
    void executeTest2() {
      var input = "input";
      target = new HelloWorld(input);
      target.execute();
      var actual = out.toString();
      var expected = input + "\n";
      assertEquals(expected, actual);
    }
  }
}
