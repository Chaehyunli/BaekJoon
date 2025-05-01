import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int origin = N;
        int counter = 1;

        int a = N % 10; // 일의 자리수
        int b = N / 10; // 십의 자리수

        N = 10 * a +((a + b) % 10);

        while(N != origin) {
            counter++;
            int A = N % 10; // 일의 자리수
            int B = N / 10; // 십의 자리수

            N = 10 * A +((A + B) % 10);
        }

        System.out.println(counter);
        
        sc.close();
    }
}
