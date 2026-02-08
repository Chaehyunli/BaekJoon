import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] matrixA, matrixB;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        matrixA = new int[N][M];
        matrixB = new int[N][M];

        // 행렬 A 입력
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = row.charAt(j) - '0';
            }
        }

        // 행렬 B 입력
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = row.charAt(j) - '0';
            }
        }

        int count = 0;

        // 3x3 연산을 수행할 수 있는 범위까지만 반복
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                // (i, j) 위치의 원소가 다르면 3x3 영역을 뒤집음
                if (matrixA[i][j] != matrixB[i][j]) {
                    flip(i, j);
                    count++;
                }
            }
        }

        // 연산 후 두 행렬이 같은지 최종 확인
        if (isSame()) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    // 3x3 부분 행렬을 뒤집는 함수
    static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                matrixA[i][j] = 1 - matrixA[i][j]; // 0은 1로, 1은 0으로
            }
        }
    }

    // 두 행렬이 일치하는지 체크하는 함수
    static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrixA[i][j] != matrixB[i][j]) return false;
            }
        }
        return true;
    }
}