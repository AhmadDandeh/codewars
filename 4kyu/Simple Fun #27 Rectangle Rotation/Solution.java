class Solution {

    static int rectangleRotation(final int a, final int b) {
        double sqrt2 = Math.sqrt(2);
        int a1 =(int) (a/sqrt2);
        int b1 =(int) (b/sqrt2);
        int sum = getSum(a1,b1);
        return sum%2==0?sum+1:sum;
    }

    private static int getSum(int a1, int b1) {
        if(a1 == 0)
            return b1;
        else if(b1 == 0){
            return a1;
        }
        else{
            return (a1+b1)*2+getSum(a1-1, b1-1);
        }
    }
}