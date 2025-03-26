import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        int[] stack = new int[N];
        int top = -1;

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack[++top] = value;
            } else if (command.equals("pop")) {
                if (top == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack[top--]);
                }
            } else if (command.equals("size")) {
                System.out.println(top + 1);
            } else if (command.equals("empty")) {
                System.out.println(top == -1 ? 1 : 0);
            } else if (command.equals("top")) {
                if (top == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack[top]);
                }
            }
        }

        sc.close();
    }
}
