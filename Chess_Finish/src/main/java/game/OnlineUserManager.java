package game;

import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;

// 名字不怕长, 就怕不清楚
// 通过这个类来管理在线用户
// 一个程序中, 不需要多个用户管理器实例. 这是一个 "单例类"
// 此处以懒汉的方式来实现
public class OnlineUserManager {
    // 使用一个 hash 表来保存在线用户信息.
    // 此处使用 ConcurrentHashMap 保证线程安全.
    // key 就是 userId, value 就是该用户对应的 websocket 的 session
    // 存好这个 session 之后, 就可以随时用这个 session 和客户端进行通信了~~
    private ConcurrentHashMap<Integer, Session> users = new ConcurrentHashMap<>();

    public void online(int userId, Session session) {
        users.put(userId, session);
    }

    public void offline(int userId) {
        users.remove(userId);
    }

    public Session getSession(int userId) {
        return users.get(userId);
    }

    private static volatile OnlineUserManager instance = null;
    private OnlineUserManager() {}

    public static OnlineUserManager getInstance() {
        if (instance == null) {
            synchronized (OnlineUserManager.class) {
                if (instance == null) {
                   instance = new OnlineUserManager();
                }
            }
        }
        return instance;
    }
}
