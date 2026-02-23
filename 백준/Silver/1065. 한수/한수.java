import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(countHanSu(n));
    }

    public static int countHanSu(int n) {
        int count = 0;

        // 1부터 n까지 모든 수를 검사
        for (int i = 1; i <= n; i++) {
            if (i < 100) {
                // 1~99는 무조건 한수
                count++;
            } else if (i < 1000) {
                // 100~999는 각 자리수 비교
                int hundreds = i / 100;      // 백의 자리
                int tens = (i / 10) % 10;    // 십의 자리
                int units = i % 10;          // 일의 자리

                // (백 - 십) == (십 - 일) 인지 확인
                if ((hundreds - tens) == (tens - units)) {
                    count++;
                }
            }
            // 1000은 등차수열이 아니므로 무시
        }
        return count;
    }
}