import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = 0; i < 5; i++) {
            result += arr[i] * arr[i];
        }

        result = result % 10;

        System.out.println(result);

        sc.close();
    }
}
