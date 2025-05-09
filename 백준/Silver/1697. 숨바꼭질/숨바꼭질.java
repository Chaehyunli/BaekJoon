import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        int max = 100001;
        boolean[] visited = new boolean[max];
        int[] time = new int[max];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(time[current]);
                return;
            }

            int[] next = {current - 1, current + 1, current * 2};
            for (int nx : next) {
                if (nx >= 0 && nx < max && !visited[nx]) {
                    queue.add(nx);
                    visited[nx] = true;
                    time[nx] = time[current] + 1;
                }
            }
        }
    }
}
