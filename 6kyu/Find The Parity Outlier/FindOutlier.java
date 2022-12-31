public class FindOutlier{
  static int find(int[] integers) {
    boolean bEven=integers[0]%2==0 && integers[1]%2==0;
    boolean bOdd=integers[0]%2!=0 && integers[1]%2!=0;
    boolean fODD=integers[0]%2!=0 && integers[1]%2==0;
    for(int i=2;i<integers.length;i++){
      if(bEven){
        if(integers[i]%2!=0)
          return integers[i];
      }
      else if(bOdd){
        if(integers[i]%2==0)
          return integers[i];
      }
      else{
        if(integers[i]%2==0)
          return fODD?integers[0]:integers[1];
        else
          return fODD?integers[1]:integers[0];
      }
    }
    return 0;
  }
}