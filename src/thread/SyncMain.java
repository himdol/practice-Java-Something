package thread;

public class SyncMain {

  public static void main(String[] args) {
    Runnable r = new RunnableEx();
    // ThreadGroup 에 의해 참조되므로 GC 대상이 아님
    new Thread(r).start();
    new Thread(r).start();
  }

}

class Account {
  private int balance = 1000;
  public int getBalance(){
    return this.balance;
  }
  public void withDraw(int money){
    if(balance >= money){
      try{
        Thread.sleep(1000);
      }catch (InterruptedException e){

      }
      balance -= money;
    }
  }
  public synchronized void withDraw1(int money) {
    if (balance >= money) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
      balance -= money;
    }
  }
  public void withDraw2( int money) {
    synchronized (this) {
      if (balance >= money) {
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        balance -= money;
      }
    }
  }
}

class RunnableEx implements Runnable {
  Account ac = new Account();
  @Override
  public void run() {
    while (ac.getBalance() > 0){
      // 100, 200, 300 중 한 값을 임의로 선택해서 출금(withDraw)
      int money = (int) (Math.random() * 3 + 1) * 100;
      ac.withDraw(money);
      System.out.println("balance : " + ac.getBalance());
    }
  }
}