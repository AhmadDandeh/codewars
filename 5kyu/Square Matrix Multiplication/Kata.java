public class Kata {
	    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int[][] c=new int[a.length][b.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                int r=0;
                for(int k=0;k<a.length;k++){
                    r+=a[i][k]*b[k][j];
                }
                c[i][j]=r;                           
            }
        }
        return c;
    }
}