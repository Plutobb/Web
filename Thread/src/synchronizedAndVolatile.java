public class synchronizedAndVolatile {
    public static int i = 0;

    static class MyThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                numSum();
            }
        }
    }

    public synchronized static void numSum(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread);
        t1.start();

        Thread t2 = new Thread(myThread);
        t2.start();


        Thread.sleep(3000);

        System.out.println(i);
    }
}
