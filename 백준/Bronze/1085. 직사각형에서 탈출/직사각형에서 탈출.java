import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int minx = Math.min(x, w - x);
        int miny = Math.min(y, h - y);

        System.out.println(Math.min(minx,miny));

        sc.close();
    }
}
