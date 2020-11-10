import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Send message to server
 */

public class ClientThread1 implements Runnable{

    private Socket socket;

    public ClientThread1(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            // 输入昵称，并发送给服务器
            String nickname = buf.readLine();
            pw.println(nickname);
            pw.flush();

            // 发送聊天信息
            while(true) {
                if(socket.isClosed()){
                    break;
                }
                String str = buf.readLine();
                String date = new SimpleDateFormat("HH:mm:ss").format(new Date());  // 时间
                pw.println(str + "        " + date);
                pw.flush();
            }

            buf.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
