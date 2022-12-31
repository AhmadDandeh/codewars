public class Maskify {
    public static String maskify(String str) {
      if(str.length()<4){
            return str;
        }
        else{
            StringBuffer repStr=new StringBuffer();
            for(int i=0;i<str.length()-4;i++)
                repStr.append("#");
            return repStr+str.substring(str.length()-4);
        }
      }
}