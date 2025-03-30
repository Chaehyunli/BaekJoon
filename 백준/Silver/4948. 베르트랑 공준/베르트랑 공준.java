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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int N = sc.nextInt();
            int num = 0;
            if(N == 0) break;
            for(int i = N + 1; i <= 2 * N; i++){
                if(isPrime(i)){
                    num++;
                }
            }
            System.out.println(num);
        }
        sc.close();
    }
}


