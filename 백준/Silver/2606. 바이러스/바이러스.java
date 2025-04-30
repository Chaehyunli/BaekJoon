import java.util.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void dfs(int v) {
        visited[v] = true;
        for (int next : graph[v]) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 컴퓨터 수
        int m = sc.nextInt();  // 네트워크 수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 네트워크 연결 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // 1번 컴퓨터부터 DFS 시작
        dfs(1);

        // 1번을 제외한 감염된 컴퓨터 수 출력
        System.out.println(count);
    }
}
