public class Spiralizor {

    private static int[] brakDireghtB;
    private static int direction;
    private static int[][] result;
    private static int row, col;
    
    public static int[][] spiralize(int size){
        if(size == 0){
            return new int[][]{};
        }
        else if(size == 1){
            return new int[][]{{1}};
        }
        else{
            // initialization
            brakDireghtB = new int[] {size, size, -1, 1};
            direction = 0;
            row = col = 0;
            // 0:right - 1:down - 2:left - 3:up
        
            result = new int[size][size];
            boolean test = true;
            while(test){
                result[row][col] = 1;
                if(!moveNext()){
                    if(!turnRight()){
                        test = false;
                    }
                }
            }
            return result;
        }
    }

    private static boolean moveNext() {
        switch(direction){
            case 0:
                if(col+1==brakDireghtB[0]){
                    return false;
                }
                col++;
                break;
            case 1:
                if(row+1==brakDireghtB[1]){
                    return false;
                }
                row++;
                break;
            case 2:
                if(col-1==brakDireghtB[2]){
                    return false;
                }
                col--;
                break;
            case 3:
                if(row-1==brakDireghtB[3]){
                    return false;
                }
                row--;
                break;
        }
        return true;
    }

    private static boolean turnRight() {
        switch(direction){
            case 0:
                if(result[row+1][col-1]==1 || row+1 == brakDireghtB[1]){System.out.println("here");
                    return false;
                }
                if(row+2<brakDireghtB[1]){
                    if(result[row+2][col]==1){
                        return false;
                    }
                }
                row++;
                direction = 1;
                brakDireghtB[0]-=2;
                break;
            case 1:
                if(result[row-1][col-1]==1 || col-1 == brakDireghtB[2]){
                    return false;
                }
                if(col-2<brakDireghtB[2]){
                    if(result[row][col-2]==1){
                        return false;
                    }
                }
                col--;
                direction = 2;
                brakDireghtB[1]-=2;
                break;
            case 2:
                if(result[row-1][col+1]==1 || row-1 == brakDireghtB[3]){
                    return false;
                }
                if(row-2<brakDireghtB[3]){
                    if(result[row-2][col]==1){
                        return false;
                    }
                }
                row--;
                direction = 3;
                brakDireghtB[2]+=2;
                break;
            case 3:
                if(result[row+1][col+1]==1 || col+1 == brakDireghtB[0]){
                    return false;
                }
                if(col+2<brakDireghtB[0]){
                    if(result[row][col+2]==1){
                        return false;
                    }
                }
                col++;
                direction = 0;
                brakDireghtB[3]+=2;
                break;
        }
        return true;
    }

}