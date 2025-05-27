import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        // 수로 생각

        System.out.println(A + B - C);

        // 문자열로 생각

        System.out.println(Integer.parseInt(String.valueOf(A) + String.valueOf(B)) - C);

        sc.close();
    }
}
