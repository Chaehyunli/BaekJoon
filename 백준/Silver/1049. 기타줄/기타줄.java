import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 필요한 줄의 개수
        int M = Integer.parseInt(st.nextToken()); // 브랜드 개수

        int minPackage = 1000; // 패키지 최소 가격 (문제 조건 최대값인 1000으로 초기화)
        int minSingle = 1000;  // 낱개 최소 가격

        // 1. 가장 싼 패키지 가격과 가장 싼 낱개 가격 찾기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, p);
            minSingle = Math.min(minSingle, s);
        }

        // 2. 예외 처리: 낱개 6개 사는 것이 패키지 1개보다 쌀 경우
        // 패키지 가격을 낱개 6개 가격으로 갱신해버리면 계산이 단순해짐
        if (minPackage > minSingle * 6) {
            minPackage = minSingle * 6;
        }

        // 3. 최소 비용 계산
        // 몫(패키지 살 갯수) * 패키지 가격
        int baseCost = (N / 6) * minPackage;
        
        // 나머지(N % 6)를 낱개로 살지, 패키지 1개로 퉁칠지 비교
        int remainderCost = Math.min((N % 6) * minSingle, minPackage);

        System.out.println(baseCost + remainderCost);
    }
}