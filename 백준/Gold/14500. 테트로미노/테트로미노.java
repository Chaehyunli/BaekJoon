import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static int max = 0;

    // 19개의 테트로미노 형태를 상대 좌표로 정의 (0, 0) 기준
    static int[][][] tetromino = {
        // I자형
        {{0,0},{0,1},{0,2},{0,3}},
        {{0,0},{1,0},{2,0},{3,0}},
        // O자형
        {{0,0},{0,1},{1,0},{1,1}},
        // L자형
        {{0,0},{1,0},{2,0},{2,1}},
        {{0,1},{1,1},{2,1},{2,0}},
        {{0,0},{0,1},{1,1},{2,1}},
        {{0,0},{0,1},{1,0},{2,0}},
        {{0,0},{1,0},{1,1},{1,2}},
        {{0,2},{1,0},{1,1},{1,2}},
        {{0,0},{0,1},{0,2},{1,2}},
        {{0,0},{0,1},{0,2},{1,0}},
        // Z자형
        {{0,0},{1,0},{1,1},{2,1}},
        {{0,1},{1,1},{1,0},{2,0}},
        {{0,0},{0,1},{1,1},{1,2}},
        {{0,1},{0,2},{1,0},{1,1}},
        // ㅗ자형
        {{0,0},{0,1},{0,2},{1,1}},
        {{0,1},{1,0},{1,1},{2,1}},
        {{0,1},{1,0},{1,1},{1,2}},
        {{0,0},{1,0},{1,1},{2,0}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                check(i, j);
            }
        }

        System.out.println(max);
    }

    // 각 좌표 (x, y)에 대해 19가지 테트로미노 모양을 전부 시도
    static void check(int x, int y) {
        for(int i = 0; i < 19; i++) {
            int sum = 0;
            boolean isValid = true;
            for(int j = 0; j < 4; j++) {
                int nx = x + tetromino[i][j][0];
                int ny = y + tetromino[i][j][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isValid = false;
                    break;
                }
                sum += map[nx][ny];
            }
            if(isValid) max = Math.max(max, sum);
        }
    }
}
