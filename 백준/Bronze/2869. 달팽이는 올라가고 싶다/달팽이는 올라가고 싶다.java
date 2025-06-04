import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int x = A - B;

        System.out.println((V - B -1) / x + 1);

        sc.close();
    }
}
