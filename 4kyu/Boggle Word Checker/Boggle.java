import java.util.ArrayList;

public class Boggle {
    
    private char[][] board;
    private String word;
    private boolean[][] visit;
    
    public Boggle(final char[][] board, final String word) {
        this.board = board;
        this.word = word;
        this.visit = new boolean[board.length][board.length];
    }
    
    public boolean check() {
        ArrayList<int[]> arrL = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    arrL.add(new int[]{i, j});
                }
            }
        }

        if (arrL.isEmpty()) {
            return false;
        }

        boolean find = true;
        for (int k = 0; k < arrL.size(); k++) {
            initVisit();
            int row = arrL.get(k)[0];
            int col = arrL.get(k)[1];
            visit[row][col]=true;
            find = DFS(row, col, word.substring(1));
            visit[row][col]=false;
            if (find) {
                break;
            }
        }
        return find;
    }

    private boolean DFS(int row, int col, String substring) {
        if (substring.isEmpty()) {
            return true;
        } 
        else {
            char c=substring.charAt(0);
            visit[row][col] = true;
            boolean t=false;
            if (row + 1 < board.length) {
                if (c == board[row + 1][col] && !visit[row + 1][col]) {
                    visit[row+1][col] = true;
                    if(DFS(row+1,col,substring.substring(1)))
                        t=true;
                    else
                        visit[row+1][col] = false;
                }
                if (col + 1 < board.length   && !t) {
                    if (c == board[row + 1][col + 1] && !visit[row + 1][col + 1]) {
                        visit[row+1][col+1] = true;
                        if(DFS(row+1,col+1,substring.substring(1)))
                            t=true;
                        else
                            visit[row+1][col+1] = false;
                    }
                } 
                
                if (col - 1 >= 0   && !t) {
                    if (c == board[row + 1][col - 1] && !visit[row + 1][col - 1]) {
                        visit[row+1][col-1] = true;
                        if(DFS(row+1,col-1,substring.substring(1)))
                            t=true;
                        else
                            visit[row+1][col-1] = false;
                    }
                }
            }

            if (row - 1 >= 0 && !t) {
                if (c == board[row - 1][col] && !visit[row - 1][col]) {
                    visit[row-1][col] = true;
                    if(DFS(row-1,col,substring.substring(1)))
                            t=true;
                    else
                        visit[row-1][col] = false;
                }
                
                if (col + 1 < board.length && !t) {
                    if (c == board[row - 1][col + 1] && !visit[row - 1][col + 1]) {
                        visit[row-1][col+1] = true;
                        if(DFS(row-1,col+1,substring.substring(1)))
                            t=true;
                        else
                            visit[row-1][col+1] = false;
                    }
                }
                
                if (col - 1 >= 0 && !t) {
                    if (c == board[row - 1][col - 1] && !visit[row - 1][col - 1]) {
                        visit[row-1][col-1] = true;
                        if(DFS(row-1,col-1,substring.substring(1)))
                            t=true;
                        else
                            visit[row-1][col-1] = false;
                    }
                }
            }

            if (col + 1 < board.length && !t) {
                if (c == board[row][col + 1] && !visit[row][col + 1]) {
                    visit[row][col+1] = true;
                    if(DFS(row,col+1,substring.substring(1)))
                            t=true;
                    else
                        visit[row][col+1] = false;
                }
            }

            if (col - 1 >= 0 && !t) {
                if (c == board[row][col - 1] && !visit[row][col - 1]) {
                    visit[row][col-1] = true;
                    if(DFS(row,col-1,substring.substring(1)))
                            t=true;
                    else
                        visit[row][col-1] = false;
                }
            }
            return t;
        }
    }
       
    private void initVisit() {
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit.length; j++) {
                visit[i][j] = false;
            }
        }
    }

}