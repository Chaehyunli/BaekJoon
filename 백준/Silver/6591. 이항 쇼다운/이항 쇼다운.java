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

        while(true){
            int n = sc.nextInt();
            int r = sc.nextInt();
            if(n == 0 & r == 0){
                sc.close();
                return;
            }
            System.out.println(combination(n, r));
        }

    }
}