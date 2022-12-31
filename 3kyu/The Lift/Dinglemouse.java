import java.util.ArrayList;

public class Dinglemouse {
    public static int[] theLift(final int[][] queues, final int capacity){
        ArrayList<Integer> visitedFloors = new ArrayList<>();
        visitedFloors.clear();
        
        ArrayList<Integer> lift = new ArrayList<>();
        lift.clear();
        int floorNumber = 0;
        final int maxFloor = queues.length-1;
        final int minFloor = 0;
        boolean UP_DOWN = true; // true=up ... false=down
        visitedFloors.add(floorNumber);
        int lastInsertedFloor = floorNumber;
        
        boolean b = !finishService(lift, queues);
        while(b){
            // remove from lift
            while(lift.contains(floorNumber)){
                // remove from lift
                lift.remove(Integer.valueOf(floorNumber));
                // add floor to visited
                if(floorNumber != lastInsertedFloor){
                    lastInsertedFloor = floorNumber;
                    visitedFloors.add(floorNumber);
                }
            }
            
            // add to lift
            if(queues[floorNumber].length>0){
                ArrayList<Integer> arrH = new ArrayList<>();
                arrH.clear();
                for(int i=0; i<queues[floorNumber].length; i++){
                    if(lift.size()<capacity){
                        if(UP_DOWN && floorNumber<queues[floorNumber][i]){
                            lift.add(queues[floorNumber][i]);
                            arrH.add(i);
                            if(floorNumber != lastInsertedFloor){
                                lastInsertedFloor = floorNumber;
                                visitedFloors.add(floorNumber);
                            }
                        }
                        else if(!UP_DOWN && floorNumber>queues[floorNumber][i]){
                            lift.add(queues[floorNumber][i]);
                            arrH.add(i);
                            if(floorNumber != lastInsertedFloor){
                                lastInsertedFloor = floorNumber;
                                visitedFloors.add(floorNumber);
                            }
                        }
                    }
                    else{
                        if(UP_DOWN && floorNumber<queues[floorNumber][i]){
                            if(floorNumber != lastInsertedFloor){
                                lastInsertedFloor = floorNumber;
                                visitedFloors.add(floorNumber);
                            }
                        }
                        else if(!UP_DOWN && floorNumber>queues[floorNumber][i]){
                            if(floorNumber != lastInsertedFloor){
                                lastInsertedFloor = floorNumber;
                                visitedFloors.add(floorNumber);
                            }
                        }
                    }
                }

                if(!arrH.isEmpty()){
                    int newArrLength = queues[floorNumber].length - arrH.size();
                    if(newArrLength>0){
                        int[] newArr = new int[newArrLength];
                        int index = 0;
                        for(int i=0; i<queues[floorNumber].length; i++){
                            if(!arrH.contains(i)){
                                newArr[index] = queues[floorNumber][i];
                                index++;
                            }
                        }
                        queues[floorNumber] = newArr;
                    }
                    else{
                        queues[floorNumber] = new int[]{};
                    }
                }
            }
            // next floor
            while(b){
                if(UP_DOWN){
                    if(floorNumber == maxFloor){
                        floorNumber= maxFloor;
                        UP_DOWN = false;
                    }
                    else{
                        floorNumber++;
                    }
                }
                else{
                    if(floorNumber == minFloor){
                        floorNumber= minFloor;
                        UP_DOWN = true;
                    }
                    else{
                        floorNumber--;
                    }
                }
                if(lift.contains(floorNumber) || queues[floorNumber].length>0){
                    break;
                }
                b = !finishService(lift, queues);
            }
        }
        if(visitedFloors.get(visitedFloors.size()-1) != minFloor){
            visitedFloors.add(minFloor);
        }
        return convertArrayListToArray(visitedFloors);
    }
    
    private static boolean finishService(ArrayList<Integer> lift, final int[][] queues){
        if(!lift.isEmpty()){
            return false;
        }
        else{
            for(int[] i: queues){
                if(i.length>0){
                    return false;
                }
            }
            return true;
        }
    }

    private static int[] convertArrayListToArray(ArrayList<Integer> arrL){
        int[] result = new int[arrL.size()];
        for(int i=0; i<arrL.size(); i++){
            result[i] = arrL.get(i);
        }
        return result;
    }

}