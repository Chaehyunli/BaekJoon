import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        int low = 0;
        int high = Collections.max(list);
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            for (int height : list) {
                if (height > mid) {
                    total += height - mid;
                }
            }

            if (total >= M) {
                result = mid; // 조건 만족 → 더 높게 잘라도 되는지 확인
                low = mid + 1;
            } else {
                high = mid - 1; // 너무 많이 잘랐으므로 낮춰야 함
            }
        }

        System.out.println(result);
        sc.close();
    }
}
