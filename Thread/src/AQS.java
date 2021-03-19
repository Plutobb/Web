import java.util.concurrent.locks.ReentrantLock;

public class AQS{

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        
        lock.unlock();
    }
}
