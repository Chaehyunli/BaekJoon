import java.util.Scanner;

class Main {
    static final int MOD = 10007;

    // 최대공약수
    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int binomial(int n, int k) {
        if (k > n / 2) k = n - k;

        long[] numerators = new long[k]; // 분자
        long[] denominators = new long[k]; // 분모

        // 분자 배열: n, n-1, ..., n-k+1
        for (int i = 0; i < k; i++) {
            numerators[i] = n - i;
            denominators[i] = i + 1;
        }

        // 분자와 분모를 최대한 약분
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                long g = gcd(numerators[i], denominators[j]);
                if (g > 1) {
                    numerators[i] /= g;
                    denominators[j] /= g;
                }
            }
        }

        // 남은 분자를 모두 곱함
        long result = 1;
        boolean isDenominatorsOne = true;

        // 분모가 모두 약분되어 1인지 확인
        for (int i = 0; i < k; i++) {
            if (denominators[i] != 1) {
                isDenominatorsOne = false;
                break;
            }
        }

        if(isDenominatorsOne){
            for(int i = 0; i < k; i++) {
                result *= numerators[i];
                result = result % MOD;
            }
            return (int) result;
        }else {
            throw new ArithmeticException("분모가 완전히 약분되지 않았습니다");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        System.out.println(binomial(N, K));
    }
}
