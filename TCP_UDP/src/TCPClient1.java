import javax.xml.ws.Service;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient1 {
    //客户端
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inetaddress = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            socket = new Socket(inetaddress,port);
            os = socket.getOutputStream();
            os.write("你好".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            os.close();
            socket.close();
        }

    }
}
