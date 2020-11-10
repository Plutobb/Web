import java.io.IOException;
import java.net.Socket;

public class Link {
    public static void linkstart() {
        try {
            Socket socket = new Socket("localhost", 4233);
            System.out.println("Connect successfully!");
            new Thread(new ClientThread1(socket)).start(); // 将信息发送给服务器的线程
            new Thread(new ClientThread2(socket)).start(); // 从服务器读取信息的线程
        } catch (IOException e) {

            // 若服务器未开启
            System.out.println("Server is closed, please try again later");
        }
    }
}
