import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        boolean found = false;
        for (int k = L; k <= 100; k++) {
            // 2N = k * (2x + k - 1)
            int temp = 2 * N - k * (k - 1);
            if (temp % (2 * k) != 0) continue;

            int x = temp / (2 * k);
            if (x < 0) continue;

            // 출력
            for (int i = 0; i < k; i++) {
                System.out.print((x + i) + " ");
            }
            found = true;
            break;
        }

        if (!found) {
            System.out.println("-1");
        }
        
        sc.close();
    }
}
