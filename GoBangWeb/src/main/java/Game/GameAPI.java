package Game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

//通过这个类处理webSocket通信相关逻辑
@ServerEndpoint(value = "/game/{userId}")
public class GameAPI {
    //客户端会发出两种请求:1.匹配请求 2.落子请求
    static class Request {
        public String type;
        public int userId;
        public String roomId;
        public int row;
        public int col;

        @Override
        public String toString() {
            return "Request{" +
                    "type='" + type + '\'' +
                    ", userId=" + userId +
                    ", roomId='" + roomId + '\'' +
                    ", row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    private int userId;

    @OnOpen
    public void onOpen(@PathParam("userId") String userIdStr, Session session) {
        this.userId = Integer.parseInt(userIdStr);
        //玩家登录:将玩家加入到在线队列中
        System.out.println("玩家建立连接:" + userId);
        onlineUserManager.getInstance().online(userId, session);
    }

    @OnClose
    public void onClose() {
        //玩家退出,将玩家从队列中剔除;
        System.out.println("玩家断开连接:" + userId);
        onlineUserManager.getInstance().offline(userId);
    }

    //onMessage 收到的数据可能是匹配请求也可能是落子请求;
    //需要根据JSON中的type来决定:type = startMatch 是匹配请求,type = putChess 是落子请求;
    //解析JSON这里用到的是:google的Gson;
    @OnMessage
    public void onMessage(String message, Session session) throws InterruptedException {
        System.out.println("收到来自玩家的信息" + userId + message);
        //实例化Gson对象;
        Gson gson = new GsonBuilder().create();
        //解析JSON;
        Request request = gson.fromJson(message, Request.class);
        //判断请求类型;
        if (request.type.equals("startMatch")) {
            //执行匹配逻辑;
            System.out.println("开始匹配");
            Matcher.getInstance().addMatchQueue(request);
        } else if (request.type.equals("putChess")) {
            //执行落子逻辑;
            Room room = RoomManager.getInstance().getRoom(request.roomId);
            room.putChess(request);
        } else {
            System.out.println("非法type值" + request.type);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("玩家连接异常:" + userId);
        onlineUserManager.getInstance().offline(userId);
        error.printStackTrace();
    }

}
