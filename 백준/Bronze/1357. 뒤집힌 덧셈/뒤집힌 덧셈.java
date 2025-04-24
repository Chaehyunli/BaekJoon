import java.util.Scanner;

class Main {

    public static int reverse(int n) {
        boolean isNegative = n < 0;
        String str = Integer.toString(Math.abs(n));
        String reversedStr = new StringBuilder(str).reverse().toString();
        int result = Integer.parseInt(reversedStr);
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(reverse(reverse(A)+reverse(B)));

        sc.close();
    }
}
