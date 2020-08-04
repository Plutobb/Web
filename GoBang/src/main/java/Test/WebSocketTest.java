package Test;

import lombok.SneakyThrows;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/webSocketTest/{userId}")
public class WebSocketTest {
    private int userId;

    //在客户端建立连接时使用
    @OnOpen
    public void onOpen(@PathParam("userId") String userIdStr,Session session){
        System.out.println("建立连接:" + userIdStr);
        this.userId = Integer.parseInt(userIdStr);
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    String resp = "" + System.currentTimeMillis();
                    sleep(1000);
                    session.getBasicRemote().sendText(resp);
                }
            }
        }.start();

    }

    @OnClose
    public void onClose(){
        System.out.println("断开连接:" + userId);
    }

    @OnError
    public void error(Session session,Throwable error){
        System.out.println("连接异常:" + userId);
        System.out.println(error.getMessage());
    }

    @OnMessage
    public void message(String message,Session session) throws IOException {
        System.out.println("收到信息: message = " + message);
        String resp = "" + System.currentTimeMillis();
        session.getBasicRemote().sendText(resp);
    }
}
