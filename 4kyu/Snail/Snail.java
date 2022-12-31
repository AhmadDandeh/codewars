public class Snail {
private static enum DIRECTIONS{ RIGHT, DOWN, LEFT, UP }
    private static int minRow, maxRow, minCol, maxCol;
    
    public static int[] snail(int[][] array) {
        if(array[0].length == 0){
            return new int[]{};
        }
        else{
            int[] res = new int[array.length*array.length];
            minRow = 0;
            maxRow = array.length;
            minCol = -1;
            maxCol = array.length;
            DIRECTIONS d = DIRECTIONS.RIGHT;
            int indexI = 0, indexJ = 0, indexR = 0;
            
            while(!cantMove(d, indexI, indexJ)){
                if(d == DIRECTIONS.RIGHT){
                    res[indexR] = array[indexI][indexJ];
                    indexR++;
                    if(indexJ+1 == maxCol){
                        maxCol--;
                        d = turnRight(d);
                        indexI++;
                    }
                    else{
                        indexJ++;
                    }
                }
                else if(d == DIRECTIONS.DOWN){
                    res[indexR] = array[indexI][indexJ];
                    indexR++;
                    if(indexI+1 == maxRow){
                        maxRow--;
                        d = turnRight(d);
                        indexJ--;
                    }
                    else{
                        indexI++;
                    }
                }
                else if(d == DIRECTIONS.LEFT){
                    res[indexR] = array[indexI][indexJ];
                    indexR++;
                    if(indexJ-1 == minCol){
                        minCol++;
                        d = turnRight(d);
                        indexI--;
                    }
                    else{
                        indexJ--;
                    }
                }
                else if(d == DIRECTIONS.UP){
                    res[indexR] = array[indexI][indexJ];
                    indexR++;
                    if(indexI-1 == minRow){
                        minRow++;
                        d = turnRight(d);
                        indexJ++;
                    }
                    else{
                        indexI--;
                    }
                }
            }
            return res;
        }
    }
    
    private static DIRECTIONS turnRight(DIRECTIONS d){
        switch(d){
            case RIGHT: return DIRECTIONS.DOWN;
            case DOWN: return DIRECTIONS.LEFT;
            case LEFT: return DIRECTIONS.UP;
            case UP: return DIRECTIONS.RIGHT;
            default: return d;
        }
    }
    
    private static boolean cantMove(DIRECTIONS d, int indexI, int indexJ) {
        switch(d){
            case RIGHT: return indexJ == maxCol && indexI == minRow;
            case DOWN: return indexJ == maxCol && indexI == maxRow;
            case LEFT: return indexJ == minCol && indexI == maxRow;
            case UP: return indexJ == minCol && indexI == minRow;
            default: return false;
        }
    }

}