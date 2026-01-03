import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스의 수 T 입력
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

            // M개의 비행 스케줄이 주어지지만, 답(N-1)을 구하는 데에는 필요하지 않음
            // 하지만 입력 스트림을 비워주기 위해 읽기는 해야 함
            for (int j = 0; j < M; j++) {
                br.readLine();
            }

            // 모든 국가(N)를 여행하기 위한 최소 비행기 종류는 항상 N-1
            sb.append(N - 1).append("\n");
        }

        System.out.println(sb);
    }
    
}
