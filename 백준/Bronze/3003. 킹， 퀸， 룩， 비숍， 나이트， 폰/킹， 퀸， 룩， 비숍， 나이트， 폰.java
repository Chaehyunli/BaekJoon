import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        System.out.print((1-a)+" "+(1-b)+" "+(2-c)+" "+(2-d)+" "+(2-e)+" "+(8-f));

        sc.close();
        
    }
}
