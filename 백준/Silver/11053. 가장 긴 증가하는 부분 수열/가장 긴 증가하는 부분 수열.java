import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];  // LIS 길이 저장용

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 로직 (이중 반복문)
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 일단 자기 자신만 포함하므로 최소 길이는 1
            
            for (int j = 0; j < i; j++) {
                // 내 앞의 숫자(j)가 나(i)보다 작으면 증가 수열 가능!
                if (arr[j] < arr[i]) {
                    // 기존의 내 길이와 (앞의 숫자 길이 + 1) 중 더 큰 것을 선택
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // dp 배열에서 가장 큰 값 찾기 (함수 대신 반복문으로 효율화)
        int max = 0;
        for (int val : dp) {
            if (val > max) {
                max = val;
            }
        }

        System.out.println(max);
    }
}
