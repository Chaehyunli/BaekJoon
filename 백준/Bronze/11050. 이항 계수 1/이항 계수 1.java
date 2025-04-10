import java.util.Scanner;

class Main {

    public static int factorial(int n) {
        if(n <= 1) return 1;

        if(buffer[n] != 0) return buffer[n];

        buffer[n] = n * factorial(n - 1);

        return buffer[n];
    }

    static int[] buffer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = 1;
        buffer = new int[n + 1];

        if(k > n/2){
            k = n - k;
        }

        for(int i = 0; i < k; i++){
            result = result * (n - i);
        }

        result = result / factorial(k);

        System.out.println(result);

        sc.close();
    }
}
