
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> list = new ArrayList<>();            // 客户端连接
    public static List<String> record = new ArrayList<>();          // 聊天记录
    public static List<String> online_member = new ArrayList<>();   // 在线成员
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(4233);
            System.out.println("Chatroom is opening!");
            while(true) {
                Socket socket = server.accept();
                list.add(socket);
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
