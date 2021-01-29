import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static Runnable getThread(int i){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("任务"+ i +"开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务"+i+"结束!");
            }
        };

    }

    public static void main(String[] args) {
        ExecutorService fixPool = Executors.newFixedThreadPool(5);
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedPool.execute(getThread(i));
        }
    }
}
