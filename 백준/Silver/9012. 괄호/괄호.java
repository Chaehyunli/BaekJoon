import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (ch == '(') {
                    stack.push(ch);
                }else if (ch == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }else {
                        flag = false;
                        break;
                    }
                }
            }

            if(!flag || !stack.isEmpty()){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }

        sc.close();
    }
}
