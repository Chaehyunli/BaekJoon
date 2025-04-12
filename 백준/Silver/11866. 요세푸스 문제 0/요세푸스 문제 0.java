import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            stack.addLast(i+1);
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < K - 1; j++) {
                int a = stack.pollFirst();
                stack.addLast(a);
            }

            int c = stack.pollFirst();
            result[i] = c;
        }

        System.out.print("<");
        for (int i = 0; i < N - 1; i++) {
            System.out.print(result[i] + ", ");
        }

        System.out.print(result[N - 1] + ">");

    }
}
