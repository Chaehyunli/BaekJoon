import java.util.Scanner;

class Main {

    public static long calculateMod(long A, long B, long C) {

        if (B == 0) return 1;

        // B가 짝수 일 때
        long half = calculateMod(A, B / 2, C);
        long result = (half * half) % C;

        // B가 홀수일 때
        if (B % 2 == 1) {
            result = (result * A) % C;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long C = sc.nextInt();

        System.out.println(calculateMod(A, B, C));

        sc.close();

    }
}
