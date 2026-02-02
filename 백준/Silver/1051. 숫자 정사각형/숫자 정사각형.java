import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        if (firstLine == null) return;
        
        StringTokenizer st = new StringTokenizer(firstLine);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int maxSide = Math.min(N, M);

        // 큰 크기부터 검사하여 찾으면 즉시 종료
        for (int k = maxSide; k > 0; k--) {
            for (int i = 0; i <= N - k; i++) {
                for (int j = 0; j <= M - k; j++) {
                    int target = board[i][j];
                    if (board[i][j + k - 1] == target &&
                        board[i + k - 1][j] == target &&
                        board[i + k - 1][j + k - 1] == target) {
                        
                        System.out.println(k * k);
                        return; // 정답을 찾으면 프로그램 종료
                    }
                }
            }
        }
    } // main 메소드 끝
} // Main 클래스 끝