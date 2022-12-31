import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Kata {
   
  public static List<Point> closestPair(List<Point> points) {
        if(points.size()>3000){
            double middle = findMidY(points);
            List<Point> pointsL = new ArrayList<>();
            pointsL.clear();
            List<Point> pointsR = new ArrayList<>();
            pointsR.clear();
            for (Point point : points) {
                if(point.y < middle){
                    pointsL.add(point);
                }
                else{
                    pointsR.add(point);
                }
            }
          if(pointsL.size()==0){
            return closestPairNormal(pointsR);
          }
          if(pointsR.size()==0){
            return closestPairNormal(pointsL);
          }
            List<Point> closestPairL = closestPair(pointsL);
            double getDisL = getDis(closestPairL.get(0), closestPairL.get(1));
            if(getDisL == 0){
                return closestPairL;
            }
            List<Point> closestPairR = closestPair(pointsR);
            double getDisR = getDis(closestPairR.get(0), closestPairR.get(1));
            if(getDisR == 0){
                return closestPairR;
            }
            double min = Math.min(getDisL, getDisR);
            List<Point> checkPossibleItems = new ArrayList<>();
            checkPossibleItems.clear();
            
            for(int i=0;i<points.size();i++){
                if(Math.abs(points.get(i).y - middle) < min){
                    checkPossibleItems.add(points.get(i));
                }
            }
            if(checkPossibleItems.isEmpty()){
                if(getDisL<getDisR){
                    return closestPairL;
                }
                else{
                    return closestPairR;
                }
            }
            List<Point> closestPairRem = closestPairNormal(checkPossibleItems);
            double remDisr = getDis(closestPairRem.get(0), closestPairRem.get(1));
            if(remDisr<min){
                return closestPairRem;
            }
            else{
                if(getDisL<getDisR){
                    return closestPairL;
                }
                else{
                    return closestPairR;
                }
            }
        }
        else{
          
            return closestPairNormal(points);
        }
    }
    
    private static List<Point> closestPairNormal(List<Point> points) {
        int firstI = -1;
        int secondI = -1;
        double dist = Double.MAX_VALUE;
        for(int i=0;i<points.size()-1;i++){
            Point P = points.get(i);
            for(int j=i+1;j<points.size();j++){
                double nDist = getDis(P, points.get(j));
                if(nDist<dist){
                    firstI = i;
                    secondI = j;
                    dist = nDist;
                }
                if(dist == 0){
                    break;
                }
            }
        }
        return Arrays.asList(new Point(points.get(firstI).x, points.get(firstI).y),new Point(points.get(secondI).x, points.get(secondI).y));
    }
    
    private static double getDis(Point p1,Point p2){
        return Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
    }
    
    public static double findMidY(List<Point> points){
        double big = Double.MIN_VALUE;
        double small = Double.MAX_VALUE;
        
        for (Point point : points) {
            if(point.y < small){
                small = point.y;
            }
            if(point.y > big){
                big = point.y;
            }
        }
        return (small+big)/2;
    }
}