package SearchClass;

public class searchWord {
    //给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

    //解题思路：因为是按照单词的字母顺序，而且在相邻的单元格内寻找，所以想到使用递归来求解，
    // 每次都向上下左右四个方向搜索，直到字母结尾返回true，否则就返回false。
    public static boolean exist(char[][] board, String word) {
        //首先找到第一个字母的位置
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (!ans) {
                        ans = existHelp(i, j, 0, board, word);
                    }
                }
            }
        }
        return ans;
    }
    public static Boolean existHelp(int row,int col,int index,char[][] board,String word){
        if (index == word.length()){
            return true;
        }
        if (row > board.length-1 || row < 0){
            return false;
        }
        if (col > board[0].length-1 || col < 0){
            return false;
        }
        if (board[row][col] != word.charAt(index)){
            return false;
        }
        char tmp = board[row][col];
        board[row][col] = '.';
        boolean ans =( existHelp(row + 1, col, index + 1, board, word) ||
                        existHelp(row - 1, col, index + 1, board, word) ||
                        existHelp(row, col + 1, index + 1, board, word) ||
                        existHelp(row, col - 1, index + 1, board, word));
        board[row][col] = tmp;
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        System.out.println(exist(board,"CAAAB"));
    }
}
