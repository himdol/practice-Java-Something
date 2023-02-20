package lambda2;

@FunctionalInterface
interface myFunctionInterface {
  void run();
}

public class MyFuntion {
  
  static void execute(myFunctionInterface f) {
    f.run();
  }

  static myFunctionInterface getMyFunction() {
    myFunctionInterface f = () -> System.out.println("f3.run()");
    return f;
  }

  public static void main(String[] args) {
    myFunctionInterface f1 = () -> System.out.println("f1.run()");

    myFunctionInterface f2 = new myFunctionInterface() {
      public void run() {
        System.out.println("f2.run()");
      }
    };

    myFunctionInterface f3 = getMyFunction();
    f1.run();
    f2.run();
    f3.run();

    execute(f1);
    execute( () -> System.out.println("run()"));
  }
  
  
}
