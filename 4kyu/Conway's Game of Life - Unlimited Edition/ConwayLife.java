import java.util.ArrayList;

public class ConwayLife {
    private static boolean change = false;
    
    public static int[][] getGeneration(int[][] cells, int generations) {
        int rowNum = cells.length;
        int colNum = cells[0].length;
        for(int g=0; g<generations; g++){
            // initialization
            int[][] cellsNextGeneration = expCells(cells, cells.length, cells[0].length);
            int[][] cellsNextGenerationCopy = new int[cells.length+2][cells[0].length+2];
            // find the next expand generation cells
            for(int i=0;i<cellsNextGeneration.length;i++){
                for(int j=0;j<cellsNextGeneration[0].length;j++){
                    if(stayLive(cellsNextGeneration, i, j)){
                        cellsNextGenerationCopy[i][j] = 1;
                    }
                    else{
                        cellsNextGenerationCopy[i][j] = 0;
                    }
                }
            }
            // collaspe array
            cells = collCells(cellsNextGenerationCopy, cellsNextGenerationCopy.length, cellsNextGenerationCopy[0].length);
            while(change){
                cells = collCells(cells, cells.length, cells[0].length);
            }
            change = false;
            if(noLiveCell(cells))
                return new int[][]{};
        }
        return cells;
    }
    
    private static int[][] expCells(int[][] cells,int rows, int cols){
        int[][] expand = new int[rows+2][cols+2];
        for(int i=1; i<rows+1;i++){
            for(int j=1; j<cols+1;j++){
                expand[i][j] = cells[i-1][j-1];
            }
        }
        return expand;
    }
    
    public static int[][] collCells(int[][] expCells, int rows, int cols){
        ArrayList<Integer> rowsDel = new ArrayList<>();
        rowsDel.clear();
        if(testRow(expCells, 0))
            rowsDel.add(0);
        if(testRow(expCells, rows-1))
            rowsDel.add(rows-1);
        // if empty
        if(rows==rowsDel.size())
            return new int[][]{};
        
        ArrayList<Integer> colsDel = new ArrayList<>();
        colsDel.clear();
        
        if(testCol(expCells, 0))
            colsDel.add(0);
        if(testCol(expCells, cols-1))
            colsDel.add(cols-1);
        // if there is no delete
        if(colsDel.isEmpty() && rowsDel.isEmpty()){
            change = false;
            return expCells;
        }
        
        change = true;
        
        int[][] coll = new int[rows-rowsDel.size()][cols-colsDel.size()];
        int collI=0, collJ=0;
        for(int i=0;i<rows;i++){
            if(!rowsDel.contains(i)){
                collJ=0;
                for(int j=0;j<cols;j++){
                    if(!colsDel.contains(j)){
                        coll[collI][collJ] = expCells[i][j];
                        collJ++;
                    }
                }
                collI++;
            }
        }
        return coll;
    }
    
    private static boolean testRow(int[][] expCells, int row){
        for(int i=0;i<expCells[0].length;i++){
            if(expCells[row][i]==1){
                return false;
            }
        }
        return true;
    }

    private static boolean testCol(int[][] expCells, int col){
        for(int i=0;i<expCells.length;i++){
            if(expCells[i][col]==1){
                return false;
            }
        }
        return true;
    }
    
    private static boolean noLiveCell(int[][] cells){
        for(int[] c:cells){
            for(int cc:c){
                if(cc==1)
                    return false;
            }
        }
        return true;
    }
    
    private static int getLiveNeighbours(int[][] cells, int row, int col){
        int count = 0;
        int rowC = cells.length;
        int colC = cells[0].length;
        if(cells[(row+1)%rowC][col]==1){
            count++;
        }        
        if(cells[(row+1)%rowC][(col+1)%colC]==1){
            count++;
        }    
        if(cells[(row+1)%rowC][(col-1+colC)%colC]==1){
            count++;
        }
        if(cells[(row-1+rowC)%rowC][col]==1){
            count++;
        }        
        if(cells[(row-1+rowC)%rowC][(col+1)%colC]==1){
            count++;
        }
        if(cells[(row-1+rowC)%rowC][(col-1+colC)%colC]==1){
            count++;
        }
        if(cells[row][(col+1)%colC]==1){
            count++;
        }
        if(cells[row][(col-1+colC)%colC]==1){
            count++;
        }
        return count;
    }
    
    private static boolean stayLive(int[][] cells, int row, int col){
        int count = getLiveNeighbours(cells, row, col);
        if(cells[row][col]==1){
            return (count==2 || count==3);
        }
        else{
            return count==3;
        }
    }
    
}