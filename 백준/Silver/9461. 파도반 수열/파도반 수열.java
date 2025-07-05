import java.util.Scanner;

class Main {

    static long[] memo = new long[101];

    public static long padovan(int n){

        if (n == 1 || n == 2 || n == 3) return 1;
        if (memo[n] != 0) return memo[n]; // 이미 계산된 경우
        return memo[n] = padovan(n - 2) + padovan(n - 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            System.out.println(padovan(a));
        }
    }
}
