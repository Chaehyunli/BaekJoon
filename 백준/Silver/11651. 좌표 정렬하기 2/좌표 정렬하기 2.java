import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] points = new int[N][2];

        // 점 입력 받기
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();  // x
            points[i][1] = sc.nextInt();  // y
        }

        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int[] point : points) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        System.out.print(sb);


    }
}
