import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < N; i++){
            String s = sc.nextLine();
            int A = Integer.parseInt(s.split(",")[0]);
            int B = Integer.parseInt(s.split(",")[1]);

            System.out.println(A+B);
        }

        sc.close();
    }
}
