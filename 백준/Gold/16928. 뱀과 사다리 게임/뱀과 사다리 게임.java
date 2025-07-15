import java.util.*;

public class Main {
    static int[] move = new int[101];     // 각 칸에서 실제 도착할 칸 (사다리/뱀 적용)
    static boolean[] visited = new boolean[101]; // 방문 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사다리 수
        int M = sc.nextInt(); // 뱀 수

        // 기본적으로 자기 자신으로 이동
        for (int i = 1; i <= 100; i++) {
            move[i] = i;
        }

        // 사다리 정보
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            move[x] = y;
        }

        // 뱀 정보
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            move[u] = v;
        }

        // BFS 수행
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0}); // 시작 위치 1, 주사위 굴린 횟수 0
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if (pos == 100) {
                return cnt;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = pos + dice;
                if (next > 100) continue;

                int dest = move[next];
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.offer(new int[] {dest, cnt + 1});
                }
            }
        }

        return -1; // 도달할 수 없을 경우
    }
}
