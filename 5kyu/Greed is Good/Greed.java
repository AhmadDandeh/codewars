public class Greed{
  public static int greedy(int[] dice){
    int[] count=new int[6];
    for(int i=0;i<5;i++){
      count[dice[i]-1]++;
    }
    int result=0;
    for(int i=0;i<count.length;i++){
      switch (i) {
        case 0:
          if(count[i]>=3){
            result+=1000;
            count[i]-=3;
          }
          result+=(100*count[i]);
          break;
        case 4:
          if(count[i]>=3){
            result+=500;
            count[i]-=3;
          }
          result+=(50*count[i]);
          break;
        default:
          if(count[i]>=3){
            result+=(100*(i+1));
          }
      }
    }
    return result;
  }
}