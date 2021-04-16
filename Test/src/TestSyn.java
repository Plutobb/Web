public class TestSyn {
    static final String lock1 = "lock1";
    static final String lock2 = "lock2";

    public static void main(String[] args) {
        new Thread(()->{
            try {
                while (true){
                    Thread.sleep(1000);
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName()+"获取了lock1");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"尝试获取lock2");
                        synchronized (lock2){
                            System.out.println(Thread.currentThread().getName()+"获取了lock2");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                while (true){
                    Thread.sleep(1000);
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName()+"获取了lock2");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"尝试获取lock1");
                        synchronized (lock1){
                            System.out.println(Thread.currentThread().getName()+"获取了lock1");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
