public class BattleField {
    private static int[] ships = new int[4];
    
    public static boolean fieldValidator(int[][] field) {
        // init
        ships[0] = 4;
        ships[1] = 3;
        ships[2] = 2;
        ships[3] = 1;
        // Test the array 10*10 and the 1_cells = 20 = (4*1 + 3*2 + 2*3 + 1*4)
        if(!passLengthCount(field)){
            return false;
        }
        else{
            // check horizontal
            for(int i=0 ; i<10 ; i++){
                for(int j=0; j<10; j++){
                    if(field[i][j] == 1){
                        int length = 1;
                        length += findLengthHorizon(field,i,j);
                        if(length>4){
                            return false;
                        }
                        else if(length == 1){
                            if(isOneCell(field, i, j)){
                                field[i][j] = 0;
                                if(checkAround(field,i,i,j,j)){
                                    ships[length-1]--;
                                }
                                else{
                                    return false;
                                }
                           }
                           else{
                               // do not do any thing ... vertical
                           }
                       }
                       else{ // (length>1 && length<5)
                           int jStart = j, jEnd = j+length-1;
                           // make the cells zero;
                           for(int k=0;k<length;k++){
                               field[i][j+k] = 0;
                           }
                           if(checkAround(field,i,i,jStart,jEnd)){
                               ships[length-1]--;
                           }
                           else{
                               return false;
                           }
                       }
                    }
                    else{
                        // the cell is zero so do not do any thing
                    }
                }
            }
            // check Vertical
            for(int j=0 ; j<10 ; j++){
                for(int i=0; i<10; i++){
                    if(field[i][j] == 1){
                        int length = 1;
                        length += findLengthVertical(field,i,j);
                        if(length>4){
                            return false;
                        }
                        else if(length == 1){
                            if(isOneCell(field, i, j)){
                                field[i][j] = 0;
                                if(checkAround(field,i,i,j,j)){
                                    ships[length-1]--;
                                }
                                else{
                                    return false;
                                }
                           }
                           else{
                               // do not do any thing
                           }
                       }
                       else{ // (length>1 && length<5)
                           int iStart = i, iEnd = i+length-1;
                           // make the cells zero;
                           for(int k=0;k<length;k++){
                               field[i+k][j] = 0;
                           }
                           if(checkAround(field,iStart,iEnd,j,j)){
                               ships[length-1]--;
                           }
                           else{
                               return false;
                           }
                       }
                    }
                    else{
                        // the cell is zero so do not do any thing
                    }
                }
            }
        }

        for(int i=0; i<4;i++){
            if(ships[i]!=0){
                return false;
            }
        }
        return true;
    }
    
    private static boolean passLengthCount(int[][] field){
        if(field.length!=10){
            return false;
        }
        else{
            int shipCellCounts = 0;
            for (int[] field1 : field) {
                if(field1.length!=10){
                    return false;
                }
                for (int j = 0; j<field1.length; j++) {
                    if (field1[j] == 1) {
                        shipCellCounts++;
                    }
                }
            }
            return shipCellCounts == 20;
        }

    }
    
    private static int findLengthHorizon(int[][] field, int i, int j) {
        if(j+1>9){
            return 0;
        }
        if(field[i][j+1] == 1){
            return 1+findLengthHorizon(field, i, j+1);
        }
        return 0;
    }
    
    private static int findLengthVertical(int[][] field, int i, int j) {
        if(i+1>9){
            return 0;
        }
        if(field[i+1][j] == 1){
            return 1+findLengthVertical(field, i+1, j);
        }
        else{
            return 0;
        }
    }
    
    private static boolean checkAround(int[][] field, int iStart, int iEnd, int jStart, int jEnd) {
        if(iStart-1<0){
            iStart = 0;
        }
        else{
            iStart--;
        }
        
        if(iEnd+1>9){
            iEnd = 9;
        }
        else{
            iEnd++;
        }
        
        if(jStart-1<0){
            jStart = 0;
        }
        else{
            jStart--;
        }
        
        if(jEnd+1>9){
            jEnd = 9;
        }
        else{
            jEnd++;
        }
        
        for(int i=iStart; i<=iEnd; i++){
            for(int j=jStart; j<=jEnd; j++){
                if(field[i][j] !=0){
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isOneCell(int[][] field, int i, int j) {
        if((i+1)<10){
            if(field[i+1][j] == 1){
                return false;
            }
        }
        
        if((i-1)>=0){
            if(field[i-1][j] == 1){
                return false;
            }
        }
        
        if(j-1>=0){
            if(field[i][j-1]==1){
                return false;
            }
        }
        
        if(j+1<10){
            if(field[i][j+1]==1){
                return false;
            }
        }
        return true;
    }
    
    
}