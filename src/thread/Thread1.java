package thread;

public class Thread1 extends Thread {
  @Override
  public void run() {
    try {
      sleep(1000);
      for (int i = 0; i < 10; i++) {
        System.out.println("1");
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
