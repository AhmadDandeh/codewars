class Lcs {
      public static String lcs(String a, String b) {
        if(b.isEmpty() || a.isEmpty()){
            return "";
        }
        
        if(a.length()<b.length()){
          String s = a;
          a = b;
          b = s;
        }
        
        String withoutFirst = lcs(a, b.substring(1));
        String withFirst = "";
        
        int index = a.indexOf(b.charAt(0)+"");
        if(index>-1)
          withFirst = b.charAt(0)+lcs(a.substring(index+1),b.substring(1));
        return withFirst.length()>withoutFirst.length()?withFirst:withoutFirst;
    }
    
}