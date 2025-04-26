import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        for (int i = 0; i <= 99; i++) {
            int x = N / 100;
            int num = x * 100 + i;
            if(num % F == 0){
                System.out.printf("%02d\n", i);
                break;
            }
        }
        
        sc.close();
    }
}
