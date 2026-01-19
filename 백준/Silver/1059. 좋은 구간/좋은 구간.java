import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 속도를 높이기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력 받기
        int L = Integer.parseInt(br.readLine()); // 집합 S의 크기
        
        int[] S = new int[L];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        int n = Integer.parseInt(br.readLine()); // 타겟 정수 n
        
        // 2. 정렬 및 n 포함 여부 확인
        Arrays.sort(S);
        
        // n이 집합 S에 이미 있다면 좋은 구간은 0개
        for(int val : S) {
            if(val == n) {
                System.out.println(0);
                return;
            }
        }
        
        // 3. n의 범위(start, end) 구하기
        int start = 0; // n보다 작은 수 중 가장 큰 수 (기본값 0)
        int end = 0;   // n보다 큰 수 중 가장 작은 수
        
        for(int val : S) {
            if(val < n) {
                start = val;
            } else if (val > n) {
                end = val;
                break; // 오름차순 정렬되어 있으므로 첫 번째로 큰 수가 바로 위 경계값
            }
        }
        
        // 4. 좋은 구간 개수 구하기
        // 구간 [i, j]는 start < i <= n <= j < end 를 만족해야 하며, i < j 여야 함
        int count = 0;
        
        // i는 (start + 1) 부터 n 까지 가능
        for (int i = start + 1; i <= n; i++) {
            // j는 n 부터 (end - 1) 까지 가능
            for (int j = n; j < end; j++) {
                if (i != j) { // A < B 조건 (구간의 시작과 끝이 같으면 안 됨)
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}