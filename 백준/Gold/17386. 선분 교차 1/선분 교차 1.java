import java.util.Scanner;

class Main {

    public static boolean isBetween(double p, int a, int b) {
        return p >= Math.min(a, b) && p <= Math.max(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        int x3 = sc.nextInt(), y3 = sc.nextInt();
        int x4 = sc.nextInt(), y4 = sc.nextInt();

        // 직선이 수직인 경우를 방지하려면 기울기 계산 전에 분모 확인 필요

        if ((x2 - x1) == 0 && (x4 - x3) == 0) {
            System.out.println(0); // 둘 다 수직선 → 평행
            return;
        } else if ((x2 - x1) == 0) {
            // 직선1 수직선
            double m2 = (double)(y4 - y3) / (x4 - x3);
            double b2 = y3 - m2 * x3;
            double px = x1;
            double py = m2 * px + b2;
            if (isBetween(py, y1, y2) && isBetween(px, x3, x4) && isBetween(py, y3, y4)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        } else if ((x4 - x3) == 0) {
            // 직선2 수직선
            double m1 = (double)(y2 - y1) / (x2 - x1);
            double b1 = y1 - m1 * x1;
            double px = x3;
            double py = m1 * px + b1;
            if (isBetween(py, y3, y4) && isBetween(px, x1, x2) && isBetween(py, y1, y2)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        // 일반적인 경우
        double m1 = (double) (y2 - y1) / (x2 - x1);
        double m2 = (double) (y4 - y3) / (x4 - x3);

        double b1 = y1 - m1 * x1;
        double b2 = y3 - m2 * x3;

        if (m1 == m2) {
            if (b1 == b2) {
                System.out.println(0); // 일치
            } else {
                System.out.println(0); // 평행
            }
            return;
        }

        double px = (b2 - b1) / (m1 - m2);
        double py = m1 * px + b1;

        if (isBetween(px, x1, x2) && isBetween(py, y1, y2)
                && isBetween(px, x3, x4) && isBetween(py, y3, y4)) {
            System.out.println(1); // 교점이 선분 위에 있음
        } else {
            System.out.println(0);
        }

        sc.close();
    }
}
