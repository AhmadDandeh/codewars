import java.util.List;
import java.util.ArrayList;

public class SlidingPuzzle {
    
        int[][] puzzleMain;
    int[][] puzzleValue;
    int puzzleLength;
    List<Integer> steps;
    int zeroPosition, zeroRow, zeroCol;
    int numberPosition, numberRow, numberCol;
    int rowsBorder, colsBorder;
    
    public SlidingPuzzle(int[][] puzzle) {
        this.puzzleLength = puzzle.length;
        this.puzzleMain = puzzle.clone();
        this.puzzleValue = new int[this.puzzleLength][this.puzzleLength];
        for(int i=0;i<this.puzzleLength;i++){
            for(int j=0; j<this.puzzleLength;j++){
                this.puzzleValue[i][j] = i*this.puzzleLength+j+1;
            }
        }
        this.steps = new ArrayList<>();
        steps.clear();
        this.zeroPosition = -1;
        this.zeroRow = -1;
        this.zeroCol = -1;
        this.numberPosition = -1;
        this.numberRow = -1;
        this.numberCol = -1;
        this.rowsBorder = 0;
        this.colsBorder = 0;
    }
    
    public List<Integer> solve(){
        this.updateZeroInfo(this.findIntPos(0));
        // Test if the puzzle can be solved
        if(!isSolvable()){
            return null;
        }
        algo();
        return this.steps;
    }
        
    private boolean isSolvable() {
        if(this.puzzleMain.length%2==1){
            return getNumberOfInversions(this.puzzleMain)%2==0;
        }
        else{
            int positionZero = this.findIntPos(0);
            int row = (int) ((positionZero-1)/this.puzzleMain.length);
            int inversions = getNumberOfInversions(this.puzzleMain);
            if((row%2==0 && inversions%2==1)||(row%2==1 && inversions%2==0)){
                return true;
            }
        }
        return false;
    }
    
    private int getNumberOfInversions(int[][] puzzleMain){
        int[] puz1 = new int[puzzleMain.length*puzzleMain.length-1];
        int count = 0;
        for(int i=0;i<puzzleMain.length;i++){
            for(int j=0;j<puzzleMain.length;j++){
                if(puzzleMain[i][j]!=0){
                    puz1[count] = puzzleMain[i][j];
                    count++;
                }
            }
        }
        int inversions = 0;
        for(int i=0;i<puz1.length-1;i++){
            for(int j=i+1;j<puz1.length;j++){
                if(puz1[i]>puz1[j]){
                    inversions++;
                }
            }
        }
        return inversions;
    }
    
    private final int findIntPos(int number){
        for(int i=0;i<this.puzzleLength;i++){
            for(int j=0;j<this.puzzleLength;j++){
                if(puzzleMain[i][j] == number){
                    return puzzleValue[i][j];
                }
            }
        }
        return -1;
    }
    
    // ======== Solution ============
    private void algo() {
        this.moveZeroToRightDownCornerStartRight();
        while(this.getNumberOfInversions(this.puzzleMain)!=0){
            if(rowsBorder == colsBorder){
                if(rowsBorder == this.puzzleLength-2){
                    this.orderLastFourCellsRightRotation();
                }
                else{
                    for(int i=colsBorder;i<this.puzzleLength-2;i++){
                        this.updateNumberInfo(this.findIntPos(this.puzzleValue[rowsBorder][i]));
                        if(this.numberCol > i){
                            this.moveNumberLeftComplex(i);
                        }
                        else if(this.numberCol < i){
                            this.moveNumberRightComplex(i);
                        }
                        if(this.numberRow>rowsBorder){
                            this.moveNumberUpComplex(rowsBorder);
                        }
                    }
                    // Last Two Numbers
                    this.updateNumberInfo(this.findIntPos(this.puzzleValue[rowsBorder][this.puzzleLength-2]));
                    if(this.numberCol < this.puzzleLength-1){
                        this.moveNumberRightComplex(this.puzzleLength-1);
                    }
                    if(this.numberRow > rowsBorder){
                        this.moveNumberUpComplex(rowsBorder);
                    }
                    this.updateNumberInfo(this.findIntPos(this.puzzleValue[rowsBorder][this.puzzleLength-1]));
                    if(this.numberPosition == (this.puzzleLength*(rowsBorder+1)-1)){
                        this.complexOrderLastTwoUp();
                    }
                    else{
                        if(this.numberCol < this.puzzleLength-1){
                            this.moveNumberRightComplex(this.puzzleLength-1);
                        }
                        if(this.numberRow > this.rowsBorder+1){
                            this.moveNumberUpComplex(rowsBorder+1);
                        }
                        this.simpleOrderLastTwoUp();
                    }
                    this.moveZeroToRightDownCornerStartDown();
                    rowsBorder++;
                }
            }
            else{
                for(int i=rowsBorder;i<this.puzzleLength-2;i++){
                    this.updateNumberInfo(this.findIntPos(this.puzzleValue[i][colsBorder]));
                    if(this.numberRow > i){
                        this.moveNumberUpComplex(i);
                    }
                    else if(this.numberRow < (i)){
                        this.moveNumberDownComplex(i);
                    }
                    if(this.numberCol>colsBorder){
                        this.moveNumberLeftComplex(colsBorder);
                    }
                }
                // Last Two Numbers
                this.updateNumberInfo(this.findIntPos(this.puzzleValue[this.puzzleLength-2][colsBorder]));
                if(this.numberRow < this.puzzleLength-1){
                    this.moveNumberDownComplex(this.puzzleLength-1);
                }
                if(this.numberCol > colsBorder){
                    this.moveNumberLeftComplex(colsBorder);
                }
                this.updateNumberInfo(this.findIntPos(this.puzzleValue[this.puzzleLength-1][colsBorder]));
                if(this.numberPosition == (this.puzzleLength*(this.puzzleLength-2)+1+colsBorder)){
                    this.complexOrderLastTwoLeft();
                }
                else{
                    if(this.numberRow < this.puzzleLength-1){
                        this.moveNumberDownComplex(this.puzzleLength-1);
                    }
                    if(this.numberCol > colsBorder+1){
                        this.moveNumberLeftComplex(colsBorder+1);
                    }
                    this.simpleOrderLastTwoLeft();
                }
                this.moveZeroToRightDownCornerStartDown();
                colsBorder++;
            }
        }
    }
    
    // =========== Update Operatios ===========
    private void updateZeroInfo(int newPosition){
        this.zeroPosition = newPosition;
        this.zeroRow = (newPosition-1)/this.puzzleLength;
        this.zeroCol = (newPosition-1)%this.puzzleLength;
    }
    
    private void updateNumberInfo(int newPosition){
        this.numberPosition = newPosition;
        this.numberRow = (newPosition-1)/this.puzzleLength;
        this.numberCol = (newPosition-1)%this.puzzleLength;
    }
    
    // =========== Simple Moves ===========
    private void swapZeroNumber(){
        this.puzzleMain[this.zeroRow][this.zeroCol] = this.puzzleMain[this.numberRow][this.numberCol];
        this.puzzleMain[this.numberRow][this.numberCol] = 0;
        this.steps.add(this.puzzleMain[this.zeroRow][this.zeroCol]);
        this.updateZeroInfo(this.puzzleValue[this.numberRow][this.numberCol]);
        this.updateNumberInfo(this.puzzleValue[this.zeroRow][this.zeroCol]);
    }
    
    private void swapZeroUp(){
        this.puzzleMain[this.zeroRow][this.zeroCol] = this.puzzleMain[this.zeroRow-1][this.zeroCol];
        this.puzzleMain[this.zeroRow-1][this.zeroCol] = 0;
        this.steps.add(this.puzzleMain[this.zeroRow][this.zeroCol]);
        this.updateZeroInfo(this.puzzleValue[this.zeroRow-1][this.zeroCol]);
    }
    
    private void swapZeroDown(){
        this.puzzleMain[this.zeroRow][this.zeroCol] = this.puzzleMain[this.zeroRow+1][this.zeroCol];
        this.puzzleMain[this.zeroRow+1][this.zeroCol] = 0;
        this.steps.add(this.puzzleMain[this.zeroRow][this.zeroCol]);
        this.updateZeroInfo(this.puzzleValue[this.zeroRow+1][this.zeroCol]);
    }
    
    private void swapZeroLeft(){
        this.puzzleMain[this.zeroRow][this.zeroCol] = this.puzzleMain[this.zeroRow][this.zeroCol-1];
        this.puzzleMain[this.zeroRow][this.zeroCol-1] = 0;
        this.steps.add(this.puzzleMain[this.zeroRow][this.zeroCol]);
        this.updateZeroInfo(this.puzzleValue[this.zeroRow][this.zeroCol-1]);
    }
    
    private void swapZeroRight(){
        this.puzzleMain[this.zeroRow][this.zeroCol] = this.puzzleMain[this.zeroRow][this.zeroCol+1];
        this.puzzleMain[this.zeroRow][this.zeroCol+1] = 0;
        this.steps.add(this.puzzleMain[this.zeroRow][this.zeroCol]);
        this.updateZeroInfo(this.puzzleValue[this.zeroRow][this.zeroCol+1]);
    }
    
    // =========== Basic Moves ===========
    private void moveZeroToRightDownCornerStartDown(){
        while(this.zeroRow != this.puzzleLength-1){
            this.swapZeroDown();
        }
        boolean t = this.zeroRow == this.numberRow && this.zeroCol<this.numberCol;
        if(t){
            this.swapZeroUp();
        }
        while(this.zeroCol != this.puzzleLength-1){
            this.swapZeroRight();
        }
        if(t){
            this.swapZeroDown();
        }
    }
    
    private void moveZeroToRightDownCornerStartRight(){
        while(this.zeroCol != this.puzzleLength-1){
            this.swapZeroRight();
        }
        boolean t = this.zeroCol == this.numberCol && this.zeroRow<this.numberRow;
        if(t){
            this.swapZeroLeft();
        }
        while(this.zeroRow != this.puzzleLength-1){
            this.swapZeroDown();
        }
        if(t){
            this.swapZeroRight();
        }
    }
    
    private void moveZeroToRightNumber(){
        if(this.numberCol != this.puzzleLength-1){
            while(this.zeroCol > this.numberCol+1){
                this.swapZeroLeft();
            }
            while(this.zeroRow != this.numberRow){
                this.swapZeroUp();
            }
        }
        else{
            System.out.println("We can't move ... out of bound");
        }
    }
    
    private void moveZeroToLeftNumber(){
        if(this.numberCol != this.colsBorder){
            if(this.zeroRow == this.numberRow){
                if(this.zeroRow != this.puzzleLength-1){
                    this.swapZeroDown();
                    while(this.zeroCol != this.numberCol-1){
                        this.swapZeroLeft();
                    }
                    this.swapZeroUp();
                }
                else{
                    this.swapZeroUp();
                    while(this.zeroCol != this.numberCol-1){
                        this.swapZeroLeft();
                    }
                    this.swapZeroDown();
                }
            }
            else{
                while(this.zeroCol != this.numberCol-1){
                    this.swapZeroLeft();
                }
                while(this.zeroRow != this.numberRow){
                    this.swapZeroUp();
                }
            }
        }
        else{
            System.out.println("We can't move ... out of bound");
        }
    }
    
    private void moveZeroToUnderNumber(){
        if(this.numberRow != this.puzzleLength-1){
            while(this.zeroRow != this.numberRow+1){
                this.swapZeroUp();
            }
            while(this.zeroCol != this.numberCol){
                this.swapZeroLeft();
            }
        }
        else{
            System.out.println("We can't move ... out of bound");
        }
    }
    
    private void moveZeroToAboveNumber(){
        if(this.numberRow != rowsBorder){
            if(this.zeroCol == this.numberCol){
                this.swapZeroLeft();
                while(this.zeroRow != this.numberRow-1){
                    this.swapZeroUp();
                }
                this.swapZeroRight();
            }
            else{
                while(this.zeroRow != this.numberRow-1){
                    this.swapZeroUp();
                }
                while(this.zeroCol != this.numberCol){
                    this.swapZeroLeft();
                }
            }
        }
        else{
            System.out.println("We can't move ... out of bound");
        }
    }
    
    private void moveZerotoAboveNumberAfterAboveSwap(){
        if(this.numberCol == this.puzzleLength-1){
            // Swap from Left
            this.swapZeroLeft();
            this.swapZeroUp();
            this.swapZeroUp();
            this.swapZeroRight();
        }
        else{
            // Swap from right
            this.swapZeroRight();
            this.swapZeroUp();
            this.swapZeroUp();
            this.swapZeroLeft();
        }
    }
    
    private void moveZerotoUnderNumberAfterUnderSwap(){ // rarely or impossible
        if(this.numberCol == this.puzzleLength-1){
            // Swap from Left
            this.swapZeroLeft();
            this.swapZeroDown();
            this.swapZeroDown();
            this.swapZeroRight();
        }
        else{
            // Swap from right
            this.swapZeroRight();
            this.swapZeroDown();
            this.swapZeroDown();
            this.swapZeroLeft();
        }
    }
    
    private void moveZerotoRightNumberAfterRightSwap(){
        if(this.numberRow == this.puzzleLength-1){
            // Swap from Up
            this.swapZeroUp();
            this.swapZeroRight();
            this.swapZeroRight();
            this.swapZeroDown();
        }
        else{
            // Swap from down
            this.swapZeroDown();
            this.swapZeroRight();
            this.swapZeroRight();
            this.swapZeroUp();
        }
    }
    
    private void moveZerotoLeftNumberAfterLeftSwap(){
        if(this.numberRow == this.puzzleLength-1){
            // Swap from Up
            this.swapZeroUp();
            this.swapZeroLeft();
            this.swapZeroLeft();
            this.swapZeroDown();
        }
        else{
            // Swap from down
            this.swapZeroDown();
            this.swapZeroLeft();
            this.swapZeroLeft();
            this.swapZeroUp();
        }
    }
    
    // =========== Complex Moves ===========
    private void simpleOrderLastTwoUp(){
        this.updateNumberInfo(this.puzzleLength*(rowsBorder+1));
        this.moveZeroToLeftNumber();
        this.swapZeroRight();
        this.swapZeroDown();
    }
    
    private void simpleOrderLastTwoLeft(){
        this.updateNumberInfo((this.puzzleLength-1)*this.puzzleLength+1+colsBorder);
        this.moveZeroToAboveNumber();
        this.swapZeroDown();
        this.swapZeroRight();
    }
    
    private void complexOrderLastTwoUp(){
        this.updateNumberInfo(this.puzzleLength*(rowsBorder+1));
        this.moveZeroToLeftNumber();
        this.swapZeroLeft();
        this.swapZeroDown();
        this.swapZeroDown();
        this.swapZeroRight();
        this.swapZeroRight();
        this.swapZeroUp();
        this.swapZeroLeft();
        this.swapZeroLeft();
        this.swapZeroUp();
        this.swapZeroRight();
        this.swapZeroRight();
        this.swapZeroDown();
    }
    
    private void complexOrderLastTwoLeft(){
        this.updateNumberInfo((this.puzzleLength-1)*this.puzzleLength+1+colsBorder);
        this.moveZeroToAboveNumber();
        this.swapZeroUp();
        this.swapZeroRight();
        this.swapZeroRight();
        this.swapZeroDown();
        this.swapZeroDown();
        this.swapZeroLeft();
        this.swapZeroUp();
        this.swapZeroRight();
        this.swapZeroUp();
        this.swapZeroLeft();
        this.swapZeroLeft();
        this.swapZeroDown();
        this.swapZeroDown();
        this.swapZeroRight();
    }

    private void orderLastFourCellsRightRotation(){
        while(this.getNumberOfInversions(this.puzzleMain) != 0){
            this.swapZeroLeft();
            this.swapZeroUp();
            this.swapZeroRight();
            this.swapZeroDown();
        }
    }

    private void moveNumberLeftComplex(int colPosition) {
        if(this.numberCol == colPosition){
            return;
        }
        this.moveZeroToLeftNumber();
        this.swapZeroNumber();
        this.numberCol--;
        this.numberPosition--;
        while(this.numberCol != colPosition){
            this.moveZerotoLeftNumberAfterLeftSwap();
            this.swapZeroNumber();
            this.numberCol--;
            this.numberPosition--;
        }
        this.moveZeroToRightDownCornerStartRight();
    }

    private void moveNumberRightComplex(int colPosition) {
        if(this.numberCol == colPosition){
            return;
        }
        
        if(this.numberRow == this.puzzleLength-1){
            this.moveZeroToAboveNumber();
            this.swapZeroNumber();
            this.numberRow--;
            this.numberPosition-=this.puzzleLength;
            this.moveZeroToRightDownCornerStartDown();
        }
        this.moveZeroToRightNumber();
        this.swapZeroNumber();
        this.numberCol++;
        this.numberPosition++;
        while(this.numberCol != colPosition){
            this.moveZerotoRightNumberAfterRightSwap();
            this.swapZeroNumber();
            this.numberCol++;
            this.numberPosition++;
        }
        if(this.zeroRow == this.puzzleLength-1){
            this.swapZeroUp();
            this.swapZeroRight();
            this.swapZeroRight();
            this.swapZeroDown();
        }
        else{
            this.swapZeroDown();
        }
        this.moveZeroToRightDownCornerStartRight();
    }

    private void moveNumberUpComplex(int rowPosition) {
        if(this.numberRow == rowPosition){
            return;
        }
        this.moveZeroToAboveNumber();
        this.swapZeroNumber();
        this.numberRow--;
        this.numberPosition-= this.puzzleLength;
        while(this.numberRow != rowPosition){
            this.moveZerotoAboveNumberAfterAboveSwap();
            this.swapZeroNumber();
            this.numberRow--;
            this.numberPosition-= this.puzzleLength;
        }
        this.moveZeroToRightDownCornerStartDown();
    }

    private void moveNumberDownComplex(int rowPosition) {
        if(this.numberRow == rowPosition){
            return;
        }
        if(this.numberCol == this.puzzleLength-1){
            this.moveZeroToLeftNumber();
            this.swapZeroNumber();
            this.numberCol--;
            this.numberPosition--;
            this.moveZeroToRightDownCornerStartDown();
        }
        this.moveZeroToUnderNumber();
        this.swapZeroNumber();
        this.numberRow++;
        this.numberPosition+= this.puzzleLength;
        while(this.numberRow != rowPosition){
            this.moveZerotoUnderNumberAfterUnderSwap();
            this.swapZeroNumber();
            this.numberRow++;
            this.numberPosition+= this.puzzleLength;
        }
        if(this.zeroCol == this.puzzleLength-1){
            this.swapZeroLeft();
            this.swapZeroDown();
            this.swapZeroDown();
            this.swapZeroRight();
        }
        else{
            this.swapZeroRight();
        }
        this.moveZeroToRightDownCornerStartDown();
    }
    
}