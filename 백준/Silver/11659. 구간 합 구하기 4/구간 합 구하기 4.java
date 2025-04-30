import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];         // 1-indexed 배열
        int[] prefixSum = new int[N + 1];   // 누적합 배열 (0번째는 항상 0)

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(prefixSum[y] - prefixSum[x - 1]);
        }

        sc.close();
    }
}
