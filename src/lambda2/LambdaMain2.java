package lambda2;

public class LambdaMain2 {

  public static void main(String[] args) {
    method(() -> System.out.println("test"));
  }

  public static void method(PrintFunction p) {
    p.print();
  }
}