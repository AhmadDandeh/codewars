public class Kata{
  public static char findMissingLetter(char[] array){
    int fC=array[0];
    for(int i=1;i<array.length;i++){
      if((char)(fC+i)!=array[i])
        return (char) (fC+i);
    }
    return ' ';
  }
}