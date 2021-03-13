public class ThreadQuestion {
    private static final Object object = new Object();
    //创建三个线程轮流打印3 2 1;
    //1.使用synchronized
    //2.使用concurrentLock
    //3.使用
    static int count = 0;

    public static void print1Test1(){
        Thread thread1 = new Thread(new Runnable() {
            @lombok.SneakyThrows
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                        if (count % 3 == 0) {
                            System.out.println(1);
                            count++;
                            object.notifyAll();
                        } else {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @lombok.SneakyThrows
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                        if (count % 3 == 1) {
                            System.out.println(2);
                            count++;
                            object.notifyAll();
                        } else {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @lombok.SneakyThrows
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                        if (count % 3 == 2) {
                            System.out.println(3);
                            count = 0;
                            object.notifyAll();
                        } else {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();

    }
    //------------------------------------------------------------------------------------------------------------------
    public static class MyRunnable implements Runnable{
        private int num;

        public MyRunnable(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (count % 3 == num-1) {
                        System.out.println(num);
                        count++;
                        object.notifyAll();
                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void printTest2(){
        MyRunnable myRunnable1 = new MyRunnable(1);
        MyRunnable myRunnable2 = new MyRunnable(2);
        MyRunnable myRunnable3 = new MyRunnable(3);
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable3).start();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        // print1Test1();
        printTest2();
    }
}
