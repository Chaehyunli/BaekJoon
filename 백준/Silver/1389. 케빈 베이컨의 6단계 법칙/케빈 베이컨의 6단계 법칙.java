import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;

    // 특정 유저에서 모든 다른 유저까지의 거리 합 계산
    public static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 유저 수
        M = sc.nextInt(); // 친구 관계 수

        graph = new ArrayList[N + 1]; // 1번부터 N번까지 사용
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 중복 방지
            if (!graph[a].contains(b)) graph[a].add(b);
            if (!graph[b].contains(a)) graph[b].add(a);
        }

        int minKevin = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 1; i <= N; i++) {
            int kevin = bfs(i);
            if (kevin < minKevin) {
                minKevin = kevin;
                result = i;
            }
        }

        System.out.println(result);
    }
}
