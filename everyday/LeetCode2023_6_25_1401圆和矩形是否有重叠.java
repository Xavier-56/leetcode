package everyday;

public class LeetCode2023_6_25_1401圆和矩形是否有重叠 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
            return true;
        }
        if (x1 <= xCenter && xCenter <= x2 && y2 <= yCenter && yCenter <= y2 + radius) {
            return true;
        }
        if (x1 <= xCenter && xCenter <= x2 && yCenter <= y1 && y1 - radius <= yCenter) {
            return true;
        }
        if (y1 <= yCenter && yCenter <= y2 && x1 >= xCenter && x1 - radius <= xCenter) {
            return true;
        }
        if (y1 <= yCenter && yCenter <= y2 && x2 <= xCenter && x2 + radius <= xCenter){
            return true;
        }
        if (distance(xCenter, yCenter, x1, y2) <= radius * radius)  {
            return true;
        }
        if (distance(xCenter, yCenter, x1, y1) <= radius * radius) {
            return true;
        }
        if (distance(xCenter, yCenter, x2, y2) <= radius * radius) {
            return true;
        }
        if (distance(xCenter, yCenter, x1, y2) <= radius * radius) {
            return true;
        }
        return  false;
    }
    public long distance(int ux, int uy, int vx, int vy) {
        return (long)Math.pow(ux - vx, 2) + (long)Math.pow(uy - vy, 2);
    }
}
