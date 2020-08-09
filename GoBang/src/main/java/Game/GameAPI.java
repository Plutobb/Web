package Game;

import javax.websocket.server.ServerEndpoint;

//通过这个类处理webSocket通信相关逻辑
@ServerEndpoint(value = "/game/{userId}")
public class GameAPI {
    //
}
