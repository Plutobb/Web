import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
    //服务端
    public static void main(String[] args) throws IOException {
        //1.先创建一个地址;
        int port = 9999;
        ServerSocket serverSocket = new ServerSocket(port);
        //2.等待客户端连接进来;
        Socket socket = serverSocket.accept();
        //3.读取客户端的信息;
        InputStream inputStream = socket.getInputStream();

        //管道流;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            baos.write(bytes,0,len);
        }
        System.out.println(baos.toString());

        //最后要关闭流;
        baos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
