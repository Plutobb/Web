import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class synchronizedAndVolatile {
    public static  int i = 0;
    static Lock lock = new ReentrantLock();

    static class MyThread implements Runnable{

        @Override
        public  void run() {
            for (int i = 0; i < 10000; i++) {
                numSum();
            }
        }
    }

    public static void numSum(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread);
        t1.start();


        Thread t2 = new Thread(myThread);
        t2.start();


        Thread.sleep(4000);

        System.out.println(i);
    }
}
