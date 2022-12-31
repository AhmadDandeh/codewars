public class CarMileage {
    private static boolean allZero(int number){
        while(number!=0){
            if(number%10!=0){
                if(number/10==0){
                    return true;
                }
                else{
                    return false;
                }
            }
            number/=10;
        }
        return false;
    }
    
    private static boolean awesomePhrases(int number, int[] awesomePhrases){
        for(int i:awesomePhrases){
            if(i==number){
                return true;
            }
        }
        return false;
    }
    
    private static boolean palindrome(int number){
        String numberS=number+"";
        for(int i=0;i<numberS.length()/2;i++){
            if(numberS.charAt(i)!=numberS.charAt(numberS.length()-i-1))
                return false;
        }
        return true;
    }
    
    private static boolean sameNumber(int number){
        String numberS=number+"";
        for(int i=1;i<numberS.length();i++){
            if(numberS.charAt(0)!=numberS.charAt(i))
                return false;
        }
        return true;
    }
    
    private static boolean incrementNumber(int number){
        int num=number%10;
        if(num==0)
            num=10;
        number/=10;
        while(number!=0){
            if((num-1)!=number%10)
                return false;
            num=number%10;
            number/=10;
        };
        return true;
    }
    
    private static boolean descrementNumber(int number){
        int num=number%10;
        number/=10;
        while(number!=0){
            if((num+1)!=number%10)
                return false;
            num=number%10;
            number/=10;
        };
        return true;
    }
    
    private static boolean allTest(int number, int[] awesomePhrases){
        return(allZero(number)||awesomePhrases(number, awesomePhrases)||palindrome(number)||sameNumber(number)||incrementNumber(number)||descrementNumber(number));
    }
    
    // Catching Car Mileage Numbers
    public static int isInteresting(int number, int[] awesomePhrases) {
      System.out.println(number); 
      if(number<98){
            return 0;
        }
        else{
            if((number>99) && allTest(number,awesomePhrases))
                return 2;
            else if(allTest(number+1, awesomePhrases))
                return 1;
            else if(allTest(number+2, awesomePhrases))
                return 1;
            else
                return 0;
        }
    }

  
}