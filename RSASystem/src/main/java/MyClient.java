import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient{

    private PrintStream ps;
    Socket socket;
    private static Scanner scanner;
    private String publicKey;
    private byte[] encrypt;
    private int flag = 0;
    private String aesKey;

    private void connect() {
        try {
            socket=new Socket("127.0.0.1",8998);
            ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readFromService() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String info = null;
        while((info=br.readLine())!=null){//循环读取服务端的信息
            if (flag == 0){//第一次收到服务端信息就是公钥
                System.out.println("客户端已经获取RSA公钥!");
                publicKey = info;
                sendAesKey();
                flag = 1;
            }else {
                //对获取的信息进行解密
                String msg = AesUtil.decrypt(info, aesKey);
                System.out.println("服务端：" + msg);
            }
        }
        br.close();
    }

    private void writeToService() throws Exception {
        String msg = scanner.nextLine();
        String msgAES = AesUtil.encrypt(msg, aesKey);
        ps.println(msgAES);
        ps.flush();
    }

    private void writeToService(byte[] bytes) throws UnsupportedEncodingException {
        String string = Base64.encodeBase64String(bytes);
        ps.println(string);
        ps.flush();
    }


    private void sendAesKey() throws Exception {
        //获取AES对称秘钥,并使用RSA公钥进行加密；
        System.out.println("客户端生成AES秘钥并通过RSA加密发送到服务器!");
        aesKey = AesUtil.getKey();
        //System.out.println(aesKey);
        encrypt = RsaUtil.encryptByPublicKey(aesKey.getBytes(), publicKey);
        writeToService(encrypt);
    }

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);

        final MyClient myClient = new MyClient();
        myClient.connect();


        new Thread(new Runnable() {
            @lombok.SneakyThrows
            @Override
            public void run() {
                while (true) {
                    myClient.readFromService();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @lombok.SneakyThrows
            @Override
            public void run() {
                while (true) {
                    myClient.writeToService();
                }
            }
        }).start();




    }

}