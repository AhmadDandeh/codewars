public class EnoughIsEnough {
  public static int[] deleteNth(int[] elements, int maxOccurrences) {
    if(maxOccurrences==0)
      return new int[]{};
    if(elements.length==0)
      return elements;
    String s="";
    for(int i=0;i<elements.length;i++){
      s+=" "+elements[i]+" ,";
    }
    String resultS="";
    int n=0;
    for(int i=0;i<elements.length;i++){
      int sL=s.length();
      String w=" "+elements[i]+" ";
      s=s.replaceAll(w,"");
      int occ=(sL-s.length())/w.length();
      for(int j=0;j<(occ>maxOccurrences?maxOccurrences:occ);j++){
        resultS+=w+",";
        n++;
      }
    }
    if(n!=0){
      int[] result=new int[n];
      int x=0;
      for(int i=0;i<elements.length;i++){
        String w=" "+elements[i]+" ";
        if(resultS.contains(w)){
          resultS=resultS.replaceFirst(w, "");
          result[x]=elements[i];
          x++;
        }
      }
      return result;
    }
    else{
      return null;
    }
	}
}