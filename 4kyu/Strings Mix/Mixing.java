import java.util.ArrayList;

public class Mixing {
    public static String mix(String s1, String s2) {
        ArrayList<String> arrLC = new ArrayList<>();
        ArrayList<Integer> arrLO = new ArrayList<>();
        ArrayList<Integer> arrLW = new ArrayList<>();
        arrLC.clear();
        arrLO.clear();
        arrLW.clear();
        for (char c = 'a'; c <= 'z'; c++) {
            int s1L = s1.length();
            int s2L = s2.length();
            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }
            s1 = s1.replaceAll(c + "", "");
            s2 = s2.replaceAll(c + "", "");

            int s1D = s1L - s1.length();
            int s2D = s2L - s2.length();

            if (!(s1D < 2 && s2D < 2)) {
                if (s1D < s2D) {
                    arrLC.add(c + "");
                    arrLO.add(s2D);
                    arrLW.add(2);
                } else if (s1D > s2D) {
                    arrLC.add(c + "");
                    arrLO.add(s1D);
                    arrLW.add(1);
                } else {
                    arrLC.add(c + "");
                    arrLO.add(s1D);
                    arrLW.add(3);
                }
            }
        }

        if (arrLC.isEmpty()) {
            return "";
        } else {
            int[][] indexs = new int[3][arrLC.size()];
            for (int i = 0; i < arrLC.size(); i++) {
                indexs[0][i] = arrLO.get(i);
                indexs[1][i] = arrLW.get(i);
                indexs[2][i] = arrLC.get(i).charAt(0);
            }

            int col = arrLC.size();
            for (int i = 0; i < col - 1; i++) {
                for (int j = i + 1; j < col; j++) {
                    if (indexs[0][i] < indexs[0][j]) {
                        int t = indexs[0][i];
                        indexs[0][i] = indexs[0][j];
                        indexs[0][j] = t;
                        t = indexs[1][i];
                        indexs[1][i] = indexs[1][j];
                        indexs[1][j] = t;
                        t = indexs[2][i];
                        indexs[2][i] = indexs[2][j];
                        indexs[2][j] = t;
                    } else if (indexs[0][i] == indexs[0][j]) {
                        if (indexs[1][i] > indexs[1][j]) {
                            int t = indexs[0][i];
                            indexs[0][i] = indexs[0][j];
                            indexs[0][j] = t;
                            t = indexs[1][i];
                            indexs[1][i] = indexs[1][j];
                            indexs[1][j] = t;
                            t = indexs[2][i];
                            indexs[2][i] = indexs[2][j];
                            indexs[2][j] = t;
                        } else if (indexs[1][i] == indexs[1][j]) {
                            if (indexs[2][i] > indexs[2][j]) {
                                int t = indexs[0][i];
                                indexs[0][i] = indexs[0][j];
                                indexs[0][j] = t;
                                t = indexs[1][i];
                                indexs[1][i] = indexs[1][j];
                                indexs[1][j] = t;
                                t = indexs[2][i];
                                indexs[2][i] = indexs[2][j];
                                indexs[2][j] = t;

                            }
                        }
                    }
                }
            }

            String res = "";
            for (int i = 0; i < col; i++) {
                String charSeq = "";
                char c = (char) indexs[2][i];
                int o = indexs[0][i];
                for (int j = 0; j < o; j++) {
                    charSeq += c;
                }
                res += (((indexs[1][i]) > 2 ? "=" : indexs[1][i]) + ":" + charSeq + "/");
            }
            res = res.substring(0, res.length() - 1);
            return res;
        }
    }
}