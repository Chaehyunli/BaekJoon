import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 계단의 수
        int[] score = new int[n];  // 각 계단의 점수

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }

        // 계단이 1개 또는 2개인 경우는 예외 처리
        if (n == 1) {
            System.out.println(score[0]);
            return;
        } else if (n == 2) {
            System.out.println(score[0] + score[1]);
            return;
        }

        // dp[i]는 i번째 계단까지 올라섰을 때의 최대 점수
        int[] dp = new int[n];

        dp[0] = score[0];
        dp[1] = score[0] + score[1];
        dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[n - 1]);
    }
}
