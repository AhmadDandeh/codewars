public class Xbonacci {

  public double[] tribonacci(double[] s, int n) {
    double[] result = new double[n];
    for (int i = 0; i < n; i++) {
      result[i] = (i<3)?s[i]:result[i - 3] + result[i - 2] + result[i - 1];
    }
    return result;
  }
}