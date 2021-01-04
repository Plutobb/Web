public class ThreadControl {
    //线程类继承Runnable接口
    static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("线程启动了!");
        }
    }
    //线程启动
    public static void startThread(){
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
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
    public static void main(String[] args) {
        //startThread();
        getAndSetThreadName();
    }
}
