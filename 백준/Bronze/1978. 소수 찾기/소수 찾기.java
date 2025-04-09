import java.util.Scanner;

class Main {

    public static boolean isPrime(int n) {

        if (n < 2) return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(isPrime(num)){
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
