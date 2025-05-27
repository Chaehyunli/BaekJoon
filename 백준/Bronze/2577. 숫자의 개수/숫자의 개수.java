import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        long res = (long) A * B * C;

        int[] count = new int[10];

        while (res > 0) {
            long x = res % 10;

            count[(int) x]++;

            res /= 10;
        }

        for(int i = 0; i < 10; i++){
            System.out.println(count[i]);
        }

        sc.close();
    }
}
