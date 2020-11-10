import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream()); 

            // 向客户端提示输入昵称
            pw.println("Please enter your nickname:");
            pw.flush();

            // 读取客户端发送的昵称，并在服务器提示上线
            String nickname = buf.readLine();
            System.out.println(nickname + " is online");

            // 给每个在线的客户端发送该客户端上线记录
            for(Socket r : Server.list) {
                if(!r.equals(this.socket)) {
                    pw = new PrintWriter(r.getOutputStream());
                    pw.println(nickname + " is online");
                    pw.flush();
                }
                else {
                    pw = new PrintWriter(r.getOutputStream());
                    pw.println("Welcome " + nickname);
                    pw.flush();
                }
            }

            // 在该客户端显示其他已上线的成员，并将自己添加进去
            for(String s : Server.online_member) {
                pw.println(s + " is online");
                pw.flush();
            }
            Server.online_member.add(nickname);

            // 在该客户端显示聊天记录
            pw = new PrintWriter(socket.getOutputStream());
            for(String s : Server.record) {
                pw.println(s);
                pw.flush();
            }

            // 自己聊天的部分
            while(true) {
                String str;
                try {
                    // 读取客户端发送的聊天信息，并记录
                    str = buf.readLine();
                    Server.record.add(nickname + ":" + str);

                    // 若正确读取聊天信息，给所有在线成员刷新该信息
                    for(Socket r : Server.list) {
                        pw = new PrintWriter(r.getOutputStream());
                        pw.println(nickname + ":" + str);
                        pw.flush();
                    }
                } catch (Exception e) {

                    // 客户端关闭后
                    System.out.println(nickname + " is offline");
                    Server.list.remove(socket);
                    Server.online_member.remove(nickname);

                    // 通知其他客户端该成员已下线
                    for(Socket r : Server.list) {
                        pw = new PrintWriter(r.getOutputStream());
                        pw.println(nickname + " is offline");
                        pw.flush();
                    }

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
