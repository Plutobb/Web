import java.util.concurrent.Semaphore;

public class ThreadControl {
    //线程类继承Runnable接口
    static class MyThread implements Runnable{
        private int count = 0;

        public int getCount(){
            return count;
        }
        @Override
        public void run() {
            //System.out.println("线程启动了!");
//                System.out.println("begin time = " + System.currentTimeMillis());
//                Thread.sleep(2000);
//                System.out.println("end time = " + System.currentTimeMillis());
//                System.out.println("线程1开始运行");
//                Thread.sleep(2000);
//                System.out.println("线程1运行结束");
//            for (int i = 0; i < 50000; i++) {
//                System.out.println("A---" + i);
//            }
            while (true){
                count++;
            }
        }
    }
    static class MyThread1 implements Runnable{
        private int count = 0;

        public int getCount(){
            return count;
        }
        @Override
        public void run() {
            //System.out.println("线程启动了!");
//                System.out.println("begin time = " + System.currentTimeMillis());
//                Thread.sleep(2000);
//                System.out.println("end time = " + System.currentTimeMillis());
//                System.out.println("线程1开始运行");
//                Thread.sleep(2000);
//                System.out.println("线程1运行结束");
//            for (int i = 0; i < 50000; i++) {
//                System.out.println("A---" + i);
//            }
            while (true){
                count++;
            }
        }
    }
    //线程启动
    public static void startThread(){
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);
        thread.start();
    }
    //线程名称设置和获取
    public static void getAndSetThreadName(){
        MyThread myThread = new MyThread();
        //线程名字在创建的时候命名
        Thread thread = new Thread(myThread,"线程1");
        thread.start();
        //通过getName()方法获取线程名字
        System.out.println("线程名字:"+thread.getName());
    }
    //通过信号量Semaphore来控制进入资源的线程数量
    public static void threadNumControl(){
        //Semaphore 中的参数就是最大容纳的信号量,也就是线程数.
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    //通过调用请求来获取信号量,每次acquire预设值就-1.
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName()+"启动");
                try {
                    Thread.sleep(2000);
                    //通过release来释放信号量,释放后预设值就+1.
                    semaphore.release();
                    System.out.println("线程" + Thread.currentThread().getName()+"退出");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.setPriority(1);
//        thread.start();
//
//        MyThread1 myThread1 = new MyThread1();
//        Thread thread1 = new Thread(myThread1);
//        thread1.setPriority(10);
//        thread1.start();
//
//        Thread.sleep(2000);
//
//        System.out.println("thread = " + myThread.getCount());
//        System.out.println("thread1 = " + myThread1.getCount());
        threadNumControl();
    }
}
