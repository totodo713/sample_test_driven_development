public class HelloWorld {

  private String message;

  public static void main(String[] args) {
    new HelloWorld().execute();
  }

  public HelloWorld() {
    this.message = "Hello, World!";
  }

  public HelloWorld(String message) {
    this.message = message;
  }

  public void execute() {
    System.out.println(this.getMessage());
  }

  public String getMessage() {
    return this.message;
  }
}
