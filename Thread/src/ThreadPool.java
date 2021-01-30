import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static Runnable getThread(int i){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("任务"+ i +"开始! " + sdf.format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务"+i+"结束! " + sdf.format(new Date()));
            }
        };

    }

    public static void main(String[] args) {
        ExecutorService fixPool = Executors.newFixedThreadPool(5);
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        ScheduledExecutorService sChePool = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 3; i++) {
            //延迟0秒,每隔5秒任务周期执行.
            sChePool.scheduleWithFixedDelay(getThread(i),0,5, TimeUnit.SECONDS);
        }
    }
}
