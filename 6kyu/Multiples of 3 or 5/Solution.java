public class Solution {

  
    private static int ArithmeticSequence (int s, int basic){
        return s*(1+s)/2*basic;
    }
    
    public static int solution(int number) {
        int sum=0;
        sum+= number%3==0?ArithmeticSequence(number/3-1,3):ArithmeticSequence(number/3,3);
        sum+= number%5==0?ArithmeticSequence(number/5-1,5):ArithmeticSequence(number/5,5);
        sum-= number%15==0?ArithmeticSequence(number/15-1,15):ArithmeticSequence(number/15,15);
        return sum;
    }
}