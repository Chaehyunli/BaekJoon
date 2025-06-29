import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();

            if(a == 0){
                stack.pop();
            }else {
                stack.push(a);
            }
        }

        int sum = 0;
        for (int n : stack) {
            sum += n;
        }

        System.out.println(sum);
        sc.close();
    }
}
