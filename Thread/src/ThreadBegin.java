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
    //匿名内部类创建线程
    public static void myThreadNiMing(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类方法创建线程"+Thread.currentThread().getName());
            }
        }).start();
    }

    //lambda表达式创建线程
    public static void myThreadLambda(){
        new Thread(()->{
            System.out.println("lambda表达式方法创建线程"+Thread.currentThread().getName());
        }).start();
    }

    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        Thread thread = new Thread(myThread1);
//        thread.start();
        myThreadLambda();
        myThreadNiMing();
    }
}
