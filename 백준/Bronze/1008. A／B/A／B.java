import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(b !=0){
            System.out.println((double) a / b);
        }
        sc.close();
    }
}
