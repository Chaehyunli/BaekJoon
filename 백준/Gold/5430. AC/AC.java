import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 성능 향상
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();  // 함수
            int n = Integer.parseInt(br.readLine());  // 배열 크기
            String arrStr = br.readLine();

            // 배열 파싱
            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                arrStr = arrStr.substring(1, arrStr.length() - 1);  // [ ] 제거
                String[] tokens = arrStr.split(",");
                for (String token : tokens) {
                    deque.add(Integer.parseInt(token));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
