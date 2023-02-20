package thread;

public class ThreadMain {

  public static void main(String[] args) {
    Thread1 th1 = new Thread1();
    Runnable r = new Thread2();
    Thread th2 = new Thread(r);

  }

  public static void thread1() {
    System.out.println("thread 1");
  }

  public static void thread2() {
    System.out.println("thread2");
  }

}
