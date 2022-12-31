public class Conversion {
  public String solution(int n) {
    String[] Ones={"I","X","C","M"};
    String[] Fives={"V","L","D"};
    String result="";
    
    int numL=(n+"").length();
    
    for(int i=0;i<(numL>3?3:numL);i++){
      switch(n%10){
        case 1: result=Ones[i]+result;break;
        case 2: result=Ones[i]+Ones[i]+result;break;
        case 3: result=Ones[i]+Ones[i]+Ones[i]+result;break;
        case 4: result=Ones[i]+Fives[i]+result;break;
        case 5: result=Fives[i]+result;break;
        case 6: result=Fives[i]+Ones[i]+result;break;
        case 7: result=Fives[i]+Ones[i]+Ones[i]+result;break;
        case 8: result=Fives[i]+Ones[i]+Ones[i]+Ones[i]+result;break;
        case 9: result=Ones[i]+Ones[i+1]+result;break;
      }
      n/=10;
    }
    while(n!=0){
      result="M"+result;
      n--;
    }
    return result;
  }
}