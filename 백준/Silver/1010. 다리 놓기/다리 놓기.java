import java.util.Scanner;

class Main {

    public static long combination(int n, int r) {
        if (r > n - r) r = n - r; // 대칭성 활용
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i=0; i < num; i++){

            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n > m) {
                System.out.println(0); // 조합이 불가능할 경우
                continue;
            }

            long result = combination(m, n);
            System.out.println(result);

        }

        sc.close();
    }
}