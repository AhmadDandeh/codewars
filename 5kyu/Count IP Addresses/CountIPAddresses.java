public class CountIPAddresses {
	    public static long ipsBetween(String start, String end) {
        long res=0;
        int index1=0;
        int index2=0;
        for(int i=0;i<4;i++){
            int index3=start.indexOf(".", index1+1);
            if(index3==-1){
                index3=start.length();
            }
            int num1=Integer.parseInt(start.substring(index1==0?index1:index1+1, index3));
            int index4=end.indexOf(".", index2+1);
            if(index4==-1){
                index4=end.length();
            }
            int num2=Integer.parseInt(end.substring(index2==0?index2:index2+1, index4));
            res=res*256+num2-num1;
            index1=index3;
            index2=index4;
        }
        return res;
    }
}