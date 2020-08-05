package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.UUID;

// 通过这个类来表示一个房间.
// 每两个玩家就构成了一个房间, 由于服务器的玩家可能很多,
// 此时程序 中就会存在多个房间实例(不是单例)
public class Room {
    private String roomId;
    private int playerId1;
    private int playerId2;

    // 房间除了需要记录玩家信息之外, 还需要记录游戏状态.
    // 当前棋盘是啥样的.
    // 使用二维数组来表示棋盘当前的状态
    private static final int MAX_ROW = 15;
    private static final int MAX_COL = 15;
    // 棋盘中的每个元素是个整数. 约定:
    // 为 0 表示该位置是空的.
    // 为 1 表示该位置是玩家 1 的子
    // 为 2 表示该位置是玩家 2 的子
    private int[][] chessBoard = new int[MAX_ROW][MAX_COL];

    // 一会需要处理 json, 准备一个 gson 对象
    private Gson gson = new GsonBuilder().create();

    public Room() {
        // 构造方法中只需要生成房间 id 即可
        // 其他 属性 都是匹配/玩家对弈过程中设定的.
        // roomId 要保证唯一性
        // 此处咱们使用 uuid 来直接生成即可(把 roomId 搞成 String 的原因)
        roomId = UUID.randomUUID().toString();
    }

    public int getPlayerId1() {
        return playerId1;
    }

    public void setPlayerId1(int playerId1) {
        this.playerId1 = playerId1;
    }

    public int getPlayerId2() {
        return playerId2;
    }

    public void setPlayerId2(int playerId2) {
        this.playerId2 = playerId2;
    }

    public String getRoomId() {
        return roomId;
    }
}
