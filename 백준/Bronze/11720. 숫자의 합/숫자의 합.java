import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        String s = sc.next();

        for (int i = 0; i < N; i++) {
            result = result + s.charAt(i) - '0';
        }

        System.out.println(result);

        sc.close();
    }

}
