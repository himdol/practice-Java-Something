package thread;

public class DaemonThreadMain implements Runnable {
  static boolean autoSave = false;
  public static void main(String[] args)  {
    Thread t1 = new Thread(new DaemonThreadMain());
    t1.setDaemon(true);
    t1.start();


    for(int i=0; i<=10; i++){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(i);

      if(i == 5){
        autoSave = true;
      }
    }
    System.out.println("메인스레드 종료");
  }

  @Override
  public void run() {
    while (true){
      try {
        Thread.sleep(3 * 1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      if(autoSave){
        autoSave();
      }
    }
  }

  private void autoSave() {
    System.out.println("자동 저장 되었습니다");
  }
}

