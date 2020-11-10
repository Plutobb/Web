import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/*
Get message from server
 */

public class ClientThread2 implements Runnable{
    private Socket socket;
    private BufferedReader buf = null;

    public ClientThread2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                try {
                    String str = buf.readLine();
                    if(str!=null) System.out.println(str);
                } catch (Exception e) {

                    // 服务器关闭
                    System.out.println("Server is closed, please try to restart");
                    break;
                }
            }

            buf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
