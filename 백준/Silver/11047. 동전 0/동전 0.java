import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();

        Integer[] M = new Integer[N];

        for (int i = 0; i < N; i++) {
            M[i] = sc.nextInt();
        }

        Arrays.sort(M, Collections.reverseOrder());

        int num = 0;

        for (int i = 0; i < N; i++) {
            int coin = P / M[i];
            P = P - M[i] * coin;
            num = num + coin;
        }

        System.out.println(num);
        sc.close();
    }
}
