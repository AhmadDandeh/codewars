public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    if(walk.length!=10){
            return false;
        }
        else{
            short NS=0,EW=0;
            for(int i=0;i<walk.length;i++){
                switch(walk[i]){
                    case 'n':NS++;break;
                    case 's':NS--;break;
                    case 'e':EW++;break;
                    case 'w':EW--;break;
                    default: return false;
                }
            }
            if((EW==0)&&(NS==0)){
                return true;
            }
            else{
                return false;
            }
        }
  }
}