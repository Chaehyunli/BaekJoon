import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader, BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐: 절댓값이 작은 순 -> 값이 작은 순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) {
                return a - b; // 값이 작은 수 우선
            } else {
                return absA - absB; // 절댓값이 작은 수 우선
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(x);
            }
        }

        // 최종 출력
        System.out.print(sb);
    }
}
