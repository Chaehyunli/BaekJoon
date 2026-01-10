import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 콘텐츠의 개수 N 입력
        int N = sc.nextInt();

        // 흥미도 점수를 저장할 배열 생성
        int[] interests = new int[N];
        
        // 결과값을 담을 변수 (범위를 고려하여 long 사용 권장, 문제 조건상 int도 가능)
        long totalSum = 0;
        long unSubscribedSum = 0;

        // 2. 흥미도 점수 입력 및 전체 합 계산
        for (int i = 0; i < N; i++) {
            interests[i] = sc.nextInt();
            totalSum += interests[i];
        }

        // 3. 구독 여부 입력 및 미구독 콘텐츠 합 계산
        for (int i = 0; i < N; i++) {
            int isRegistered = sc.nextInt();
            
            // 등록되어 있지 않은 경우(0)만 더함
            if (isRegistered == 0) {
                unSubscribedSum += interests[i];
            }
        }

        // 4. 결과 출력
        System.out.println(totalSum);
        System.out.println(unSubscribedSum);
        
        sc.close();
    }
}