import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger C = BigInteger.valueOf(10);

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            BigInteger A = BigInteger.valueOf(a);
            BigInteger B = BigInteger.valueOf(b);

            BigInteger result = A.modPow(B,C);

            int answer = result.intValue();
            if (answer == 0) answer = 10;

            System.out.println(answer);
        }

        sc.close();
    }
}
