public class SudokuValidator {
    private static boolean check9(String s){
        for(int i=1;i<=9;i++){
            s=s.replaceFirst(""+i, "");
        }
        return s.isEmpty();
    }
    public static boolean check(int[][] sudoku) {
        String row,col;
        for(int i=0;i<9;i++){
            row="";
            col="";
            for(int j=0;j<9;j++){
                row+=sudoku[i][j];
                col+=sudoku[j][i];
            }
            if(!check9(row)||!check9(col)){
                return false;
            }
        }
        
        String box;
        for(int k=0;k<9;k++){
            box="";
            int ii=(k/3)*3;
            int jj=(k*3)%9;
            for(int i=ii;i<3+ii;i++){
                for(int j=jj;j<3+jj;j++){
                    box+=sudoku[i][j];
                }
            }
            if(!check9(box)){
                return false;
            }
        }
        return true;
    }

}