package Game;

import java.util.concurrent.ConcurrentHashMap;
//这个类来管理房间对象;
public class RoomManager {
    //创建一个Hash来存放Room;
    //key:代表roomId value:代表Room对象;
    private ConcurrentHashMap<String,Room> rooms = new ConcurrentHashMap<>();

    public void addRoom(Room room){
        rooms.put(room.getRoomId(),room);
    }
    public void removeRoom(String roomId){
        rooms.remove(roomId);
    }
    public Room getRoom(String roomId){
        return rooms.get(roomId);
    }

    private static volatile RoomManager Instance = null;
    public static RoomManager getInstance(){
        if (Instance == null){
            synchronized (RoomManager.class){
                if (Instance == null){
                    Instance = new RoomManager();
                }
            }
        }
        return Instance;
    }

    public RoomManager() { }
}
