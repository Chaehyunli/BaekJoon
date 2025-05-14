import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int M, N;
    static int[][] box;
    static int[][] days; // 각 위치가 읽은 날짜
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[1], y = t[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && box[ny][nx] == 0){
                    box[ny][nx] = 1; // 익게 하기
                    days[ny][nx] = days[y][x] + 1; // 날짜 1 더하기
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로
        box = new int[N][M];
        days = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    q.add(new int[]{i, j}); // 익은 토마토의 위치를 큐에 넣음
                }
            }
        }

        bfs(); // 토마토 익하기

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    // 안 읽은 토마토가 있으면
                    System.out.println("-1");
                    return;
                }
                count = Math.max(count, days[i][j]);
            }
        }

        System.out.println(count);
        
        sc.close();
    }
}
