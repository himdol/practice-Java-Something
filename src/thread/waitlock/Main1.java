package thread.waitlock;

public class Main1 {

  public static void main(String[] args) throws InterruptedException {
    Table table = new Table();

    new Thread(new Cook(table), "COOK1").start();
    new Thread(new Customer(table, "donut"), "CUST1").start();
    new Thread(new Customer(table, "bugger"), "CUST2").start();
    System.out.println("commit 날라감 ?");
    Thread.sleep(100);
    System.exit(0);
  }

}
