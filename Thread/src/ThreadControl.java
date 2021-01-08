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

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.setPriority(1);
        thread.start();

        MyThread1 myThread1 = new MyThread1();
        Thread thread1 = new Thread(myThread1);
        thread1.setPriority(10);
        thread1.start();

        Thread.sleep(2000);

        System.out.println("thread = " + myThread.getCount());
        System.out.println("thread1 = " + myThread1.getCount());
    }
}
