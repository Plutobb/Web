package Game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//这个类用来管理匹配系统
public class Matcher {
    Gson gson = new GsonBuilder().create();

    //匹配成功后的响应数据;
    public static class MatcherResponse{
        public String type;
        public String roomId;
        public Boolean isWhite;
        public int otherUserId;
    }
    //创建用于匹配的阻塞队列;
    public BlockingQueue<GameAPI.Request> queue = new LinkedBlockingQueue();
    //将用户请求加入到队列中;
    public void addMatchQueue(GameAPI.Request request) throws InterruptedException {
        queue.put(request);
    }
    //创建一个线程实现实时的匹配;
    private Matcher() {
        new Thread(()->{
            while (true){
                try {
                    handlerMatch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void handlerMatch() throws InterruptedException {
        try {
            //实现匹配过程;
            //1.获取两个玩家的信息,也就是获取请求;
            GameAPI.Request player1 = queue.take();//玩家1
            GameAPI.Request player2 = queue.take();//玩家2
            //2.检测玩家是否在线,例如匹配后关闭页面,导致不在线的问题;
            System.out.println("匹配到两个玩家" + player1.userId+" " + player2.userId);
            onlineUserManager manager = onlineUserManager.getInstance();
            Session session1 = manager.getSession(player1.userId);
            Session session2 = manager.getSession(player2.userId);
            if (session1 == null){
                System.out.println("玩家离线" + player1.userId);
                return;
            }
            if (session2 == null){
                System.out.println("玩家离线" + player1.userId);
                return;
            }
            if (session1 == session2){
                System.out.println("匹配到自己了");
                return;
            }
            //3.将两个玩家加入到"房间"对象中;
            Room room = new Room();
            room.setPlayer1Id(player1.userId);
            room.setPlayer2Id(player2.userId);
            //4.将房间加入到RoomManager中;
            RoomManager.getInstance().addRoom(room);
            System.out.println("玩家进入房间成功:"+room.getRoomId());
            //5.给玩家1,2分别发送房间信息
            MatcherResponse response1 = new MatcherResponse();
            response1.type = "startMatch";
            response1.roomId = room.getRoomId();
            response1.isWhite = true;
            response1.otherUserId = player2.userId;
            String JsonResponse1 = gson.toJson(response1);
            System.out.println("给玩家1发送消息"+JsonResponse1);
            session1.getBasicRemote().sendText(JsonResponse1);

            MatcherResponse response2 = new MatcherResponse();
            response2.type = "startMatch";
            response2.roomId = room.getRoomId();
            response2.isWhite = false;
            response2.otherUserId = player1.userId;
            String JsonResponse2 = gson.toJson(response2);
            System.out.println("给玩家2发送消息"+JsonResponse2);
            session2.getBasicRemote().sendText(JsonResponse2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static volatile Matcher Instance = null;
    public static Matcher getInstance(){
        if (Instance == null){
            synchronized (Matcher.class){
                if (Instance == null){
                    Instance = new Matcher();
                }
            }
        }
        return Instance;
    }
}
