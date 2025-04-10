import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            sum += x;
            if (x > max) {
                max = x;
            }
        }

        float avg = (float) sum / N;

        float newAvg = avg/(float) max * 100;

        System.out.println(newAvg);

        sc.close();
    }
}
