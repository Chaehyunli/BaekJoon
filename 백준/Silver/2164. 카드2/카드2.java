import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> stack = new LinkedList<>(); // 앞과 뒤 양쪽에서 값을 빼고 넣고 가능

        for (int i = 0; i < N; i++) {
            stack.add(i+1);
        }

        while(stack.size() > 1) {
            //System.out.println(stack);
            stack.pollFirst();
            //System.out.println(stack);
            if (!stack.isEmpty()) {
                stack.addLast(stack.pollFirst());
            }
        }

        System.out.println(stack.peekFirst());
    }
}
