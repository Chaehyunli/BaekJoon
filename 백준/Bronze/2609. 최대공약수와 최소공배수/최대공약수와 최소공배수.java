import java.util.Scanner;

class Main {

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(GCD(a, b));
        System.out.println(a * b / GCD(a, b));

        sc.close();
    }
}
