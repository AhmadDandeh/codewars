public class Kata {
public static int[] arrayDiff(int[] a, int[] b) {
        if(a.length==0 || b.length==0)
            return a;
        String aS=" ";
        for(int i:a){
            aS+=i+" ";
        }
        for(int i=0;i<b.length;i++){
            aS=aS.replaceAll(" "+b[i]+" ", " ");
            if(aS.contains(" "+b[i]+" "))
                i--;
        }
        if(aS.trim().isEmpty())
            return new int[]{};
        String aSA[]=aS.trim().split(" ");
        int[] result=new int[aSA.length];
        for(int i=0;i<aSA.length;i++){
            result[i]=Integer.parseInt(aSA[i]);
        }
        return result;
  }
}