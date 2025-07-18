import java.util.*;

public class Main {
    static int N;
    static char[][] normal;      // 일반 시야
    static char[][] colorBlind;  // 적록색약 시야
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        normal = new char[N][N];
        colorBlind = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                normal[i][j] = c;
                colorBlind[i][j] = (c == 'G') ? 'R' : c;  // G를 R로 바꿔 저장
            }
        }

        visited = new boolean[N][N];
        int normalCount = countAreas(normal);

        visited = new boolean[N][N];
        int blindCount = countAreas(colorBlind);

        System.out.println(normalCount + " " + blindCount);
    }

    static int countAreas(char[][] grid) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(grid, i, j, grid[i][j]);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(char[][] grid, int x, int y, char color) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && grid[nx][ny] == color) {
                    dfs(grid, nx, ny, color);
                }
            }
        }
    }
}
