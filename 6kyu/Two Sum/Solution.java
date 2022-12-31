public class Solution{
  public static int[] twoSum(int[] numbers, int target){
    for(int num1=0;num1<numbers.length-1;num1++){
      for(int num2=num1+1;num2<numbers.length;num2++){
        if(numbers[num1]+numbers[num2]==target){
          return new int[]{num1,num2};
        }
      }
    }
    return null;
  }
}