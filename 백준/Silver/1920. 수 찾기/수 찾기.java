import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] s1 = sc.nextLine().split(" ");
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(input);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            System.out.println(binarySearch(input, target));
        }

        sc.close();
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) return 1;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }

        return 0;
    }
}
