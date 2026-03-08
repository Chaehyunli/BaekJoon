import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int gcd = getGCD(a, b);
            // 최소공배수 = (두 수의 곱) / 최대공약수
            int lcm = (a * b) / gcd;

            // 문제에서 요구한 대로 최소공배수, 최대공약수 순으로 출력
            System.out.println(lcm + " " + gcd);
        }
        sc.close();
    }

    // 유클리드 호제법을 이용한 최대공약수 메서드
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}