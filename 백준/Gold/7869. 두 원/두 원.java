import java.util.Scanner;

class Main {

    public static double getIntersectionArea(double x1, double y1, double r1,
                                             double x2, double y2, double r2) {
        double d = Math.hypot(x1 - x2, y1 - y2);

        // 겹치지 않는 경우
        if (d >= r1 + r2) return 0.0;

        // 한 원이 다른 원 안에 완전히 포함된 경우
        if (d <= Math.abs(r1 - r2)) {
            double r = Math.min(r1, r2);
            return Math.PI * r * r;
        }

        // 겹치는 경우
        double angle1 = 2 * Math.acos((d*d + r1*r1 - r2*r2) / (2 * d * r1)); // 각도 계산
        double angle2 = 2 * Math.acos((d*d + r2*r2 - r1*r1) / (2 * d * r2));

        double area1 = 0.5 * r1*r1 * (angle1 - Math.sin(angle1)); // 부채꼴 - 삼각형 의 넓이
        double area2 = 0.5 * r2*r2 * (angle2 - Math.sin(angle2));

        return area1 + area2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double r1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double r2 = sc.nextDouble();

        double result = getIntersectionArea(x1, y1, r1, x2, y2, r2);
        System.out.printf("%.3f\n", result);
    }
}
