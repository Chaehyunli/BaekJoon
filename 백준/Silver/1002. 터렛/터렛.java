import java.util.Scanner;

class Main {

    public static double distance(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            double d = distance(x1, y1, x2, y2);
            int result;

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    result = -1; // 무한대의 접점 (동일한 원)
                } else {
                    result = 0; // 중심은 같지만 반지름이 다름 (접점 없음)
                }
            } else {
                if (d > r1 + r2) {
                    result = 0; // 원이 서로 떨어짐
                } else if (d == r1 + r2) {
                    result = 1; // 외접
                } else if (d == Math.abs(r1 - r2)) {
                    result = 1; // 내접
                } else if (d < Math.abs(r1 - r2)) {
                    result = 0; // 한 원이 다른 원 안에 있음 (접점 없음)
                } else {
                    result = 2; // 두 점에서 만남
                }
            }

            System.out.println(result);
        }

        sc.close();
    }
}