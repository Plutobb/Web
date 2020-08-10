package Game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.UUID;

public class Room {

    public static class putChessResponse{
        public String type = "putChess";
        public int userId;
        public int col;
        public int row;
        public int winner;
    }
    private String roomId;
    private int player1Id;
    private int player2Id;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(int player1) {
        this.player1Id = player1;
    }

    public int getPlayer2() {
        return player2Id;
    }

    public void setPlayer2Id(int player2) {
        this.player2Id = player2;
    }

    //保证房间名字的唯一,这里使用UUID随机生成一个;
    public Room() {
        roomId = UUID.randomUUID().toString();
    }

    //创建棋盘;
    //0:表示没落子;
    //1:表示玩家1的子;
    //2:表示玩家2的子;
    private static final int MAX_ROW = 15;
    private static final int MAX_COL = 15;
    private int[][] chessBoard = new int[MAX_ROW][MAX_COL];

    private Gson gson = new GsonBuilder().create();

    public void putChess(GameAPI.Request request){
        try {
            //1. 玩家落子;
            int chess = request.userId == player1Id ? 1:2;
            int row = request.row;
            int col = request.col;
            if (chessBoard[row][col] != 0){
                System.out.println("落子位置有误!"+request);
                return;
            }
            chessBoard[row][col] = chess;
            //打印出棋盘信息,方便调试;
            printChessBoard();
            //2. 判断胜负;
            int winner = checkWinner(row,col,chess);
            //3. 返回响应给客户端;
            //两个客户端接收到的响应是一致的;
            putChessResponse response = new putChessResponse();
            response.userId = request.userId;
            response.row = row;
            response.col = col;
            response.winner = winner;
            //给玩家发送信息,需要获取到session;
            onlineUserManager users = onlineUserManager.getInstance();
            Session session1 = users.getSession(player1Id);
            Session session2 = users.getSession(player2Id);
            if (session1 == null){
                //玩家1离线,玩家2获胜;
                response.winner = player2Id;
            }
            if (session2 == null){
                response.winner = player1Id;
            }
            String responseJson = gson.toJson(response);
            if (session1 != null){
                session1.getBasicRemote().sendText(responseJson);
            }
            if (session2 != null){
                session2.getBasicRemote().sendText(responseJson);
            }
            //4. 结束后就可以解散房间;
            if (response.winner != 0){
                RoomManager.getInstance().removeRoom(roomId);
                System.out.println("胜负已分房间销毁"+roomId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void printChessBoard(){
        System.out.println("打印棋盘信息:");
        System.out.println("========================");
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                System.out.print(chessBoard[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("========================");
    }
    private int checkWinner(int row,int col,int chess){
        // 是否分出胜负
        boolean done = false;
        // 1. 检查所有行
        for (int c = col - 4; c <= col; c++) {
            if (c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[row][c] == chess
                    && chessBoard[row][c+1] == chess
                    && chessBoard[row][c+2] == chess
                    && chessBoard[row][c+3] == chess
                    && chessBoard[row][c+4] == chess
            ) {
                done = true;
            }
        }
        // 2. 检查所有列
        for (int r = row - 4; r <= row; r++) {
            if (r < 0 || r >= MAX_ROW) {
                continue;
            }
            if (chessBoard[r][col] == chess
                    && chessBoard[r+1][col] == chess
                    && chessBoard[r+2][col] == chess
                    && chessBoard[r+3][col] == chess
                    && chessBoard[r+4][col] == chess
            ) {
                done = true;
            }
        }
        // 3. 判断左对角线
        for (int r = row - 4, c = col - 4; r <= row && c <= col; r++, c++) {
            if (r < 0 || r >= MAX_ROW || c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[r][c] == chess
                    && chessBoard[r+1][c+1] == chess
                    && chessBoard[r+2][c+2] == chess
                    && chessBoard[r+3][c+3] == chess
                    && chessBoard[r+4][c+4] == chess
            ) {
                done = true;
            }
        }
        // 4. 判断右对角线
        for (int r = row - 4, c = col + 4; r <= row && c >= col; r++, c--) {
            if (r < 0 || r >= MAX_ROW || c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[r][c] == chess
                    && chessBoard[r+1][c-1] == chess
                    && chessBoard[r+2][c-2] == chess
                    && chessBoard[r+3][c-3] == chess
                    && chessBoard[r+4][c-4] == chess
            ) {
                done = true;
            }
        }
        if (!done) {
            return 0;
        }
        return chess == 1 ? player1Id : player2Id;
    }
    public static volatile Room Instance = null;
    public static Room getInstance(){
        if (Instance == null){
            synchronized (Room.class){
                if (Instance == null){
                    Instance = new Room();
                }
            }
        }
        return Instance;
    }
}
