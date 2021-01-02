public class ThreadBegin {
    //初识线程
    public static void test1(){
        System.out.println(Thread.currentThread().getName());
    }
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("继承Thread类创建的线程");
        }
    }

    public static class MyThread1 implements Runnable{

        @Override
        public void run() {
            System.out.println("继承Runnable接口创建的线程");
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.run();
    }
}
