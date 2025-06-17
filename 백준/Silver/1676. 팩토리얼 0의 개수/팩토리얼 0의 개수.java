import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(N / 5 + N / 25 + N / 125);

        sc.close();
    }
}
