public class ThreadControl {
    //线程类继承Runnable接口
    static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                //System.out.println("线程启动了!");
                System.out.println("begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyThread1 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                System.out.println("i = " + i);
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
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);
        thread.start();
        Thread.sleep(2);
        thread.interrupt();
        System.out.println("线程中断标志1 :" + thread.isInterrupted());
        System.out.println("线程中断标志2 :" + thread.isInterrupted());
    }
}
