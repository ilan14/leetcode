package math;

import java.util.Arrays;

/**
 * 面试题 16.03. Intersection LCCI 两线段交点
 *
 * Given two straight line segments (represented as a start point and an end point), compute the point of intersection, if any. If there's no intersection, return an empty array.
 *
 * The absolute error should not exceed 10^-6. If there are more than one intersections, return the one with smallest X axis value. If there are more than one intersections that have same X axis value, return the one with smallest Y axis value.
 *
 */
public class IntersectionLCCI {
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        LineSegment line1 = LineSegment.ofPoints(start1, end1);
        LineSegment line2 = LineSegment.ofPoints(start2, end2);

        double[] result = new double[2];
        // 两条线至少有一条垂直于x轴
        if (line1.isVertical || line2.isVertical) {
            if (line1.isVertical && line2.isVertical) {
                if (line1.x != line2.x) {
                    return new double[0];
                }

                result[0] = line1.x;
                if ((start2[1] >= start1[1] && start2[1] <= end1[1]) || (start2[1] >= end1[1] && start2[1] <= start1[1])) {
                    result[1] = start2[1];
                    return result;
                }

                if (end2[1] >= start1[1] && end2[1] <= end1[1]) {
                    result[1] = start1[1];
                    return result;
                }

                if (end2[1] >= end1[1] && end2[1] <= start1[1]) {
                    result[1] = end1[1];
                    return result;
                }

                return new double[0];
            }

            if (line1.isVertical) {
                double y = line2.k * line1.x + line2.b;
                if (line1.isYInSegment(y) && line2.isYInSegment(y)) {
                    result[0] = line1.x;
                    result[1] = y;
                    return result;
                }
            }

            if (line2.isVertical) {
                double y = line1.k * line2.x + line1.b;
                if (line1.isYInSegment(y) && line2.isYInSegment(y)) {
                    result[0] = line2.x;
                    result[1] = y;
                    return result;
                }
            }

            return new double[0];
        }

        // 两直线平行或重合
        if (line1.k == line2.k) {
            // 重合
            if (line1.b == line2.b) {
                if (line1.isXInSegment(start2[0])) {
                    result[0] = start2[0];
                    result[1] = start2[1];
                    return result;
                }

                if (line1.isXInSegment(end2[0])) {
                    result[0] = start1[0];
                    result[1] = start1[1];
                    return result;
                }
            }

            return new double[0];
        } else {
            // 相交
            // 求出两直线交点
            double targetX;
            double targetY;

            targetX = (line2.b - line1.b) / (line1.k - line2.k);
            targetY = line1.k * targetX + line1.b;

            // 判断交点是否在线段范围内
            if (line1.isXInSegment(targetX) && line2.isXInSegment(targetX)) {
                result[0] = targetX;
                result[1] = targetY;
                return result;
            } else {
                return new double[0];
            }
        }
    }

    public static void main(String[] args) {
        int[] start1 = {0, 0};
        int[] end1 = {0, 1};
        int[] start2 = {1, 0};
        int[] end2 = {1, 1};
        double[] result = intersection(start1, end1, start2, end2);
        for (double x : result) {
            System.out.println(x);
        }
    }
}

class LineSegment {
    boolean isVertical;
    int x;
    double k;
    double b;
    private int[] start;
    private int[] end;

    static LineSegment ofPoints(int[] point1, int[] point2) {
        LineSegment segment = new LineSegment();

        if (point1[0] <= point2[0]) {
            segment.start = point1;
            segment.end = point2;
        } else {
            segment.start = point2;
            segment.end = point1;
        }

        if (point1[0] == point2[0]) {
            segment.x = point1[0];
            segment.isVertical = true;
        } else {
            segment.k = (double) (point2[1] - point1[1]) / (point2[0] - point1[0]);
            segment.b = point2[1] - point2[0] * segment.k;
        }
        return segment;
    }

    public boolean isXInSegment(double x) {
        return x >= start[0] && x <= end[0];
    }

    public boolean isYInSegment(double y) {
        return (y >= start[1] && y <= end[1]) || (y >= end[1] && y <= start[1]);
    }

    @Override
    public String toString() {
        return "LineSegment{" +
                "x=" + x +
                ", k=" + k +
                ", b=" + b +
                ", start=" + Arrays.toString(start) +
                ", end=" + Arrays.toString(end) +
                '}';
    }
}
