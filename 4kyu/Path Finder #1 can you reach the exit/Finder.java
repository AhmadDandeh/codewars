public class Finder {
  private static boolean[][] visited;
  public static boolean pathFinder(String maze) {
    int width=maze.indexOf("\n");
    maze=maze.replace("\n", "");
    if(width==-1){
      width=1;
    }  
    visited=new boolean[width][width];
    String[][] map=new String[width][width];
    for(int i=0;i<width;i++){
      for(int j=0;j<width;j++){
        visited[i][j]=false;
        map[i][j]=maze.charAt(i*width+j)+"";
      }
    }
    return move(map, 0, 0);
  }
    
  public static boolean move(String[][] map, int iIndex, int jIndex){
    visited[iIndex][jIndex]=true;
    if("W".equals(map[iIndex][jIndex])){
      return false;
    }
    else if((iIndex==map.length-1)&&(iIndex==jIndex)){
      return true;
    }
    else{
      boolean nB=false,sB=false,eB=false,wB=false;
      // can move to east?
      if(iIndex==0){
        eB=false;
      }
      else{
        if(visited[iIndex-1][jIndex]){
          eB=false;
        }
        else{
          eB=move(map, iIndex-1, jIndex);
        }
      }
      // can move to west?
      if(iIndex==map.length-1){
        wB=false;
      }
      else{
        if(visited[iIndex+1][jIndex]){
          wB=false;
        }
        else{
          wB=move(map, iIndex+1, jIndex);
        }
      }
      // can move to north?
      if(jIndex==0){
        nB=false;
      }
      else{
        if(visited[iIndex][jIndex-1]){
          nB=false;
        }
        else{
          nB=move(map, iIndex, jIndex-1);
        }
      }
      // can move to south?
      if(jIndex==map.length-1){
        sB=false;
      }
      else{
        if(visited[iIndex][jIndex+1]){
          sB=false;
        }
        else{
          sB=move(map, iIndex, jIndex+1);
        }
      }
      return nB||sB||eB||wB;
    }
  }
}