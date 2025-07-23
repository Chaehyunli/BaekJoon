import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 초기 인벤토리

        int[][] land = new int[N][M];
        int min = 256, max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                land[i][j] = height;
                min = Math.min(min, height);
                max = Math.max(max, height);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = -1;

        for (int h = min; h <= max; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - h;
                    if (diff > 0) {
                        time += diff * 2;
                        inventory += diff;
                    } else {
                        time += -diff;
                        inventory += diff;
                    }
                }
            }

            if (inventory >= 0 && (time < resultTime || (time == resultTime && h > resultHeight))) {
                resultTime = time;
                resultHeight = h;
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}
