public class ScreenLock {
    
    private static int numberOfCombinations;
    public int calculateCombinations(char startPosition, int patternLength){
        if(patternLength <= 0 || patternLength>9){
            return 0;
        }
        else if(patternLength == 1){
            return 1;
        }
        else{
            int rowStart=-1, colStart=-1;
            switch(startPosition){
                case 'A': rowStart = 0; colStart = 0; break;
                case 'B': rowStart = 0; colStart = 1; break;
                case 'C': rowStart = 0; colStart = 2; break;
                case 'D': rowStart = 1; colStart = 0; break;
                case 'E': rowStart = 1; colStart = 1; break;
                case 'F': rowStart = 1; colStart = 2; break;
                case 'G': rowStart = 2; colStart = 0; break;
                case 'H': rowStart = 2; colStart = 1; break;
                case 'I': rowStart = 2; colStart = 2; break;
            }
            if(rowStart <0 || colStart<0){
                return -1;
            }
            numberOfCombinations = 0;
            boolean[][] array = new boolean[3][3];
            array[rowStart][colStart] = true;
            // use function
            calculateCombinationsDFS(rowStart, colStart, array, patternLength-1);
            return numberOfCombinations;
        }
    }

    private void calculateCombinationsDFS(int rowStart, int colStart, boolean[][] array, int patternLength) {
        if(patternLength == 0){
            numberOfCombinations++;
        }
        else{
            // go down
            if(rowStart+1<3 && !array[rowStart+1][colStart]){
                array[rowStart+1][colStart] = true;
                calculateCombinationsDFS(rowStart+1, colStart, array, patternLength-1);
                array[rowStart+1][colStart] = false;
            }
            // go up
            if(rowStart-1>-1){
                if(!array[rowStart-1][colStart]){
                    array[rowStart-1][colStart] = true;
                    calculateCombinationsDFS(rowStart-1, colStart, array, patternLength-1);
                    array[rowStart-1][colStart] = false;
                }
            }
            // go right
            if(colStart+1<3){
                if(!array[rowStart][colStart+1]){
                    array[rowStart][colStart+1] = true;
                    calculateCombinationsDFS(rowStart, colStart+1, array, patternLength-1);
                    array[rowStart][colStart+1] = false;
                }
            }
            // go left
            if(colStart-1>-1){
                if(!array[rowStart][colStart-1]){
                    array[rowStart][colStart-1] = true;
                    calculateCombinationsDFS(rowStart, colStart-1, array, patternLength-1);
                    array[rowStart][colStart-1] = false;
                }
            }
            // go down right
            if(rowStart+1<3 && colStart+1<3){
                if(!array[rowStart+1][colStart+1]){
                    array[rowStart+1][colStart+1] = true;
                    calculateCombinationsDFS(rowStart+1, colStart+1, array, patternLength-1);
                    array[rowStart+1][colStart+1] = false;
                }
            }
            // go down left
            if(rowStart+1<3 && colStart-1>-1){
                if(!array[rowStart+1][colStart-1]){
                    array[rowStart+1][colStart-1] = true;
                    calculateCombinationsDFS(rowStart+1, colStart-1, array, patternLength-1);
                    array[rowStart+1][colStart-1] = false;
                }
            }
            // go up right
            if(rowStart-1>-1 && colStart+1<3){
                if(!array[rowStart-1][colStart+1]){
                    array[rowStart-1][colStart+1] = true;
                    calculateCombinationsDFS(rowStart-1, colStart+1, array, patternLength-1);
                    array[rowStart-1][colStart+1] = false;
                }
            }
            // go up left
            if(rowStart-1>-1 && colStart-1>-1){
                if(!array[rowStart-1][colStart-1]){
                    array[rowStart-1][colStart-1] = true;
                    calculateCombinationsDFS(rowStart-1, colStart-1, array, patternLength-1);
                    array[rowStart-1][colStart-1] = false;
                }
            }
            // go down down right
            if(rowStart+2<3 && colStart+1<3){
                if(!array[rowStart+2][colStart+1]){
                    array[rowStart+2][colStart+1] = true;
                    calculateCombinationsDFS(rowStart+2, colStart+1, array, patternLength-1);
                    array[rowStart+2][colStart+1] = false;
                }
            }
            // go down down left
            if(rowStart+2<3 && colStart-1>-1){
                if(!array[rowStart+2][colStart-1]){
                    array[rowStart+2][colStart-1] = true;
                    calculateCombinationsDFS(rowStart+2, colStart-1, array, patternLength-1);
                    array[rowStart+2][colStart-1] = false;
                }
            }            
            // go up up right
            if(rowStart-2>-1 && colStart+1<3){
                if(!array[rowStart-2][colStart+1]){
                    array[rowStart-2][colStart+1] = true;
                    calculateCombinationsDFS(rowStart-2, colStart+1, array, patternLength-1);
                    array[rowStart-2][colStart+1] = false;
                }
            }
            // go up up left
            if(rowStart-2>-1 && colStart-1>-1){
                if(!array[rowStart-2][colStart-1]){
                    array[rowStart-2][colStart-1] = true;
                    calculateCombinationsDFS(rowStart-2, colStart-1, array, patternLength-1);
                    array[rowStart-2][colStart-1] = false;
                }
            }
            // go down right right
            if(rowStart+1<3 && colStart+2<3){
                if(!array[rowStart+1][colStart+2]){
                    array[rowStart+1][colStart+2] = true;
                    calculateCombinationsDFS(rowStart+1, colStart+2, array, patternLength-1);
                    array[rowStart+1][colStart+2] = false;
                }
            }
            // go up right right
            if(rowStart-1>-1 && colStart+2<3){
                if(!array[rowStart-1][colStart+2]){
                    array[rowStart-1][colStart+2] = true;
                    calculateCombinationsDFS(rowStart-1, colStart+2, array, patternLength-1);
                    array[rowStart-1][colStart+2] = false;
                }
            }
            // go down left left
            if(rowStart+1<3 && colStart-2>-1){
                if(!array[rowStart+1][colStart-2]){
                    array[rowStart+1][colStart-2] = true;
                    calculateCombinationsDFS(rowStart+1, colStart-2, array, patternLength-1);
                    array[rowStart+1][colStart-2] = false;
                }
            }
            // go up left left
            if(rowStart-1>-1 && colStart-2>-1){
                if(!array[rowStart-1][colStart-2]){
                    array[rowStart-1][colStart-2] = true;
                    calculateCombinationsDFS(rowStart-1, colStart-2, array, patternLength-1);
                    array[rowStart-1][colStart-2] = false;
                }
            }
            // go down down
            if(rowStart+2<3){
                if(!array[rowStart+2][colStart] && array[rowStart+1][colStart]){
                    array[rowStart+2][colStart] = true;
                    calculateCombinationsDFS(rowStart+2, colStart, array, patternLength-1);
                    array[rowStart+2][colStart] = false;
                }
            }
            // go up up
            if(rowStart-2>-1){
                if(!array[rowStart-2][colStart] && array[rowStart-1][colStart]){
                    array[rowStart-2][colStart] = true;
                    calculateCombinationsDFS(rowStart-2, colStart, array, patternLength-1);
                    array[rowStart-2][colStart] = false;
                }
            }
            // go right right
            if(colStart+2<3){
                if(!array[rowStart][colStart+2]  && array[rowStart][colStart+1]){
                    array[rowStart][colStart+2] = true;
                    calculateCombinationsDFS(rowStart, colStart+2, array, patternLength-1);
                    array[rowStart][colStart+2] = false;
                }
            }
            // go left left
            if(colStart-2>-1){
                if(!array[rowStart][colStart-2]  && array[rowStart][colStart-1]){
                    array[rowStart][colStart-2] = true;
                    calculateCombinationsDFS(rowStart, colStart-2, array, patternLength-1);
                    array[rowStart][colStart-2] = false;
                }
            }
            // go down down right right
            if(rowStart+2<3 && colStart+2<3){
                if(!array[rowStart+2][colStart+2]  && array[rowStart+1][colStart+1]){
                    array[rowStart+2][colStart+2] = true;
                    calculateCombinationsDFS(rowStart+2, colStart+2, array, patternLength-1);
                    array[rowStart+2][colStart+2] = false;
                }
            }
            // go down down left left
            if(rowStart+2<3 && colStart-2>-1){
                if(!array[rowStart+2][colStart-2]  && array[rowStart+1][colStart-1]){
                    array[rowStart+2][colStart-2] = true;
                    calculateCombinationsDFS(rowStart+2, colStart-2, array, patternLength-1);
                    array[rowStart+2][colStart-2] = false;
                }
            }
            // go up up right right
            if(rowStart-2>-1 && colStart+2<3){
                if(!array[rowStart-2][colStart+2]  && array[rowStart-1][colStart+1]){
                    array[rowStart-2][colStart+2] = true;
                    calculateCombinationsDFS(rowStart-2, colStart+2, array, patternLength-1);
                    array[rowStart-2][colStart+2] = false;
                }
            }
            // go up up left left
            if(rowStart-2>-1 && colStart-2>-1){
                if(!array[rowStart-2][colStart-2]  && array[rowStart-1][colStart-1]){
                    array[rowStart-2][colStart-2] = true;
                    calculateCombinationsDFS(rowStart-2, colStart-2, array, patternLength-1);
                    array[rowStart-2][colStart-2] = false;
                }
            }
        }
    }
    
}