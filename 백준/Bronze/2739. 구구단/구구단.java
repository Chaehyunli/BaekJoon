import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 1;

        for (int i = 1; i <= 9; i++) {
            System.out.println(n + " * " + a + " = " + n * a);
            a++;
        }
    }
}
