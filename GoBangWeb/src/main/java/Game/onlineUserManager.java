package Game;

import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;

//这个类来管理在线用户
public class onlineUserManager {
    //此处使用Hash表来存储玩家;
    //为保证线程安全使用 ConcurrentHashMap :key 来存储userId ,value来存储Session 和 Websocket,确保通信;
    private ConcurrentHashMap<Integer, Session> users = new ConcurrentHashMap();

    private onlineUserManager() {
    }

    //玩家上线
    public void online(int userId, Session session) {
        users.put(userId, session);
    }

    //玩家下线
    public void offline(int userId) {
        users.remove(userId);
    }

    //获取session信息
    public Session getSession(int userId) {
        return users.get(userId);
    }

    //单例创建对象;
    private static volatile onlineUserManager Instance = null;

    public static onlineUserManager getInstance() {
        if (Instance == null) {
            synchronized (onlineUserManager.class) {
                if (Instance == null) {
                    Instance = new onlineUserManager();
                }
            }
        }
        return Instance;
    }
}
