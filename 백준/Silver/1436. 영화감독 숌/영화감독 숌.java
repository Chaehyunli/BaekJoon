import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;

        int x = 666;

        while(count < N) {
            if (String.valueOf(x).contains("666")) {
                count++;
            }
            x++;
        }

        System.out.println(x - 1);

        sc.close();
    }
}
