import java.util.Scanner;

class Main {

    public static Long tileWay(int n){
        if(n == 1){ return 1L;}
        if(n == 2){ return 2L;}

        if(buffer[n] != null){
            return buffer[n];
        }

        buffer[n] = (tileWay(n - 1) + tileWay(n - 2)) % 10007;
        return buffer[n];
    }

    static Long[] buffer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        buffer = new Long[N + 1];
        System.out.println(tileWay(N));

        sc.close();
    }
}