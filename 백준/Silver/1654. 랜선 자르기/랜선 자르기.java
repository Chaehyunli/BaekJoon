import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) max = arr[i];
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long length : arr) {
                count += (length / mid);
            }

            if (count >= N) {
                result = mid;  // 조건을 만족하므로 결과 저장
                left = mid + 1;  // 더 긴 길이 시도
            } else {
                right = mid - 1;  // 길이 줄이기
            }
        }

        System.out.println(result);
        
        sc.close();
    }
}
