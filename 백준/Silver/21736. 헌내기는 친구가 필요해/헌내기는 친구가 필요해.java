import java.util.*;

class Main {
    static int n, m;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 개행 제거

        campus = new char[n][m];
        visited = new boolean[n][m];

        int startX = -1, startY = -1;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // BFS 실행
        int result = bfs(startX, startY);
        if (result > 0) {
            System.out.println(result);
        } else {
            System.out.println("TT");
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = currX + dx[dir];
                int ny = currY + dy[dir];

                // 범위 안에 있고, 벽이 아니며, 방문하지 않은 곳
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && campus[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        if (campus[nx][ny] == 'P') {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
