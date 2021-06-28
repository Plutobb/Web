import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class Service {
    private BufferedReader reader;
    private PrintStream ps;
    private ServerSocket server;
    private Socket socket;
    private String aesKeyString;
    private String aesKey;
    private int flag = 0;

    void getServer(){
        try {
            server=new ServerSocket(8998);        //实例化Socket对象
            out.println("服务器创建完毕!");
            //创建新线程实现向客户端发送数据
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    while (true){
                        sendClientMessage();
                    }
                }
            }).start();

            //等待客户端连接，接收客户端的数据
            while(true) {
                socket=server.accept();           //accept()方法会返回一个和客户端Socket对象相连的Socket对象

                reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

                //当客户连接进来就发送给客户端RSA公钥
                out.println("产生RSA密匙对,并发送给客户端公钥！");
                String publicKey = RsaUtil.getPublicKey();
                sendClientMessage(publicKey);

                getClientMessage();

            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //读取客户端发送过来的信息
    private void getClientMessage() {
        try {
            while(true) {
                //获得客户端信息
                String info = null;
                while((info=reader.readLine())!=null){//循环读取客户端的信息
                    if (flag == 0){//首次收到的为加密后的AES对称秘钥
                        aesKeyString = info;
                        getAesKey();
                        flag = 1;
                    }else {
                        //对获取的信息进行解密
                        String msg = AesUtil.decrypt(info, aesKey);
                        System.out.println("客户端：" + msg);
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            if(reader!=null) {
                reader.close();
            }
            if(socket!=null) {
                socket.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void sendClientMessage() throws Exception {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        //对信息进行加密
        String msgAES = AesUtil.encrypt(msg, aesKey);
        ps.println(msgAES);
        ps.flush();
    }

    private void sendClientMessage(String publicKey){
        ps.println(publicKey);
        ps.flush();
    }

    private void getAesKey() throws Exception {
        byte[] aesKeyByte = RsaUtil.decryptByPrivateKey(Base64.decodeBase64(aesKeyString),RsaUtil.getPrivateKey());
        aesKey = new String(aesKeyByte);
        out.println("服务器已经获取AES对称秘钥！");
        out.println("开始加密通信!");
        //out.println(aesKey);
    }


    public static void main(String[] args) {
        Service service = new Service();
        service.getServer();


    }
}
