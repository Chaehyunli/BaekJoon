import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과 저장

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int current = 1;  // 다음에 push할 숫자
        boolean possible = true;

        for (int num : sequence) {
            // 현재 수열의 수(num)까지 stack에 push
            while (current <= num) {
                stack.push(current++);
                sb.append("+\n");
            }

            // pop해서 num과 비교
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 만들 수 없는 수열
                possible = false;
                break;
            }
        }

        // 출력
        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
