import java.util.Scanner;

class Main {

    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int GoldBarh(int num) {
        int mid = num / 2;
        for(int i = mid; i < num; i++) {
            if (isPrime(i) && isPrime(num - i)) {
                return i;
            };
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (GoldBarh(num) > (num -GoldBarh(num))) {
                System.out.println((num - GoldBarh(num)) + " " + GoldBarh(num));
            }else {
                System.out.println(GoldBarh(num) + " " + (num - GoldBarh(num)));
            }
        }

        sc.close();
    }
}
