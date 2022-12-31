import java.util.LinkedList;

public class Chess {

  private static final int[][] knightMove = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    private static int boardMax = 8;
    private static int boardMin = -1;
    private static boolean[][] boardVisited;
    private static int[] finishPos;
    
    public static int knight(String start, String  finish) {
        if(start.equals(finish)){
            return 0;
        }
        else{
            int[] startPos = getPosition(start);
            finishPos = getPosition(finish);
            boardVisited = new boolean[boardMax][boardMax];
            LinkedList<int[]> queue=new LinkedList<>();
            queue.clear();
            queue.add(new int[]{startPos[0], startPos[1], 0});
            boardVisited[startPos[0]][startPos[1]] = true;
            while(!queue.isEmpty()){
                int[] f = queue.pop();
                for(int i = 0; i<knightMove.length; i++){
                    int newI = f[0]+knightMove[i][0];
                    int newJ = f[1]+knightMove[i][1];
                    if(!isVisitedBefore(newI, newJ)){
                        boardVisited[newI][newJ] = true;
                        if(reachedGoal(newI, newJ)){
                            return f[2]+1;
                        }
                        else{
                            queue.add(new int[]{newI, newJ, f[2]+1});
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private static int[] getPosition(String s){
        int i = -1, j = -1;
        s = s.toLowerCase();
        switch(s.charAt(0)){
            case 'a': i = 0; break;
            case 'b': i = 1; break;
            case 'c': i = 2; break;
            case 'd': i = 3; break;
            case 'e': i = 4; break;
            case 'f': i = 5; break;
            case 'g': i = 6; break;
            case 'h': i = 7; break;
        }
        j = Integer.parseInt(s.charAt(1)+"")-1;
        return new int[]{i,j};
    }
    
    private static boolean isPossibleMove(int i, int j){
        return (i<boardMax)&&(i>boardMin)&&(j<boardMax)&&(j>boardMin);
    }
    
    private static boolean isVisitedBefore(int i, int j){
        return isPossibleMove(i, j)?boardVisited[i][j]:true;
    }

    private static boolean reachedGoal(int i, int j){
        return ((i == finishPos[0])&&(j == finishPos[1]));
    }

}