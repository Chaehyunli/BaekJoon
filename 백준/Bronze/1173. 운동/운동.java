import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 목표 운동 시간
        int m = sc.nextInt(); // 초기 맥박, 최소 맥박
        int M = sc.nextInt(); // 최대 맥박
        int T = sc.nextInt(); // 운동 시 맥박 증가량
        int R = sc.nextInt(); // 휴식 시 맥박 감소량

        if (m + T > M) {
            System.out.println(-1); // 아예 운동을 시작할 수 없음
            return;
        }

        int pulse = m;
        int exerciseTime = 0;
        int totalTime = 0;

        while (exerciseTime < N) {
            if (pulse + T <= M) {
                // 운동 가능
                pulse += T;
                exerciseTime++;
            } else {
                // 휴식
                pulse -= R;
                if (pulse < m) {
                    pulse = m;
                }
            }
            totalTime++;
        }

        System.out.println(totalTime);
    }
}
