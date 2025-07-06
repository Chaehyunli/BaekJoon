import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();

            if (line.equals(".")) {
                break;
            }

            if (isBalanced(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 균형 잡힘
    }
}
