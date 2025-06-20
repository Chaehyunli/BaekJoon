import java.util.Scanner;

class Main {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false; 

        for (int i = 3; i * i <= n; i += 2) {  // 홀수만 √n까지 검사
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        StringBuilder br = new StringBuilder();

        for (int i = A; i <= B; i++) {
            if (isPrime(i)) {
                br.append(i).append('\n');  // 줄바꿈은 \n으로 통일
            }
        }

        System.out.print(br);  // println이 아니라 print
        sc.close();
    }
}
