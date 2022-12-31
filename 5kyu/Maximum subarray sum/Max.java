public class Max {
  public static int sequence(int[] arr) {
    int sumBasic=0;
    boolean change=true;
    for(int i=0;i<arr.length;i++){
      if(arr[i]>0){
        if(change){
          change=false;
          int sumIBig=arr[i];
          int sum=arr[i];
          for(int j=i+1;j<arr.length;j++){
            if(arr[j]>=0){
              sum+=arr[j];
            }
            else{
              if(sum>sumIBig)
                sumIBig=sum;
                sum+=arr[j];
            }
          }
          if(sum>sumIBig)
            sumIBig=sum;
          if(sumIBig>sumBasic){
            sumBasic=sumIBig;
          }
        }
      }
      else{
        change=true;
      }
    }
    return sumBasic;
  }
}