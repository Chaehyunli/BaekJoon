import java.util.Scanner;

class Main {
    static final int MAX = 1000000;
    static boolean[] isNotPrime = new boolean[MAX + 1]; // 소수 여부 저장 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 에라토스테네스의 체로 소수 판별 미리 수행
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            boolean found = false;
            for (int i = 2; i <= n / 2; i++) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }

        sc.close();
    }
}
