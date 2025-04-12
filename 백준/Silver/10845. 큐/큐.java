import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                queue.offerLast(num);
            } else if (command.equals("pop")) {
                System.out.println(queue.isEmpty() ? -1 : queue.pollFirst());
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (command.equals("front")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
            } else if (command.equals("back")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
            }
        }

        sc.close();
    }
}
