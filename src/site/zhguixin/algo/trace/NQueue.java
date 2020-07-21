package site.zhguixin.algo.trace;

import java.util.ArrayList;
import java.util.List;

// N皇后问题
// 在一个棋盘中放置Q, 则该位置上的同一行、同一列、同一斜线上
public class NQueue {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        NQueue nQueue = new NQueue();
        nQueue.find(8);
    }

    private List<char[][]> result = new ArrayList<>();

    public void find(int N) {
        char[][] board = new char[N][N];
        traceBack(0, board);
        System.out.println("size=" + result.size());
        char[][] res = result.get(0);
        for (int i = 0; i < N;i++) {
            System.out.println();
            for (int j=0;j<N;j++) {
                System.out.print(res[i][j]);
            }
        }
    }

    // 回溯算法, 在某一个确定的行上, 考察从第一列到最后一列看看是否可以摆放皇后
    private void traceBack(int row, char[][] board) {
        if (row == board.length) {
            result.add(board);
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            traceBack(row + 1, board);
            board[row][col] = '.';
        }
    }

    // 是否可以在board[row][col]的位置上放置Q
    private boolean isValid(char[][] board, int row, int col) {
        // 考察第col列上有没有放置Q
        for (int i = 0; i < board.length; i ++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 考察右上方有没有放置Q
        for (int i = row-1, j=col+1;i >=0 && j<board.length;i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }


        // 考察左上方有没有放置Q
        for (int i=row-1, j=col-1;i>=0 && j>=0;i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
