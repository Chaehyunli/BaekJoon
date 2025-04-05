import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = -1000000;
        int min = 1000000;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }

        System.out.println(min + " " + max);

        sc.close();
    }
}
