import java.util.Scanner;

class Main {

    static Long[] buffer;

    // 타일이 들어가는 경우의 수
    public static Long tileWay(int n) {
        if (n == 1) return 1L;
        if (n == 2) return 3L;

        if (buffer[n] != null) return buffer[n]; // 이미 버퍼에 계산된 값이 있으면 계산하지 않고, 바로 리턴

        buffer[n] = (tileWay(n - 1) + 2 * tileWay(n - 2)) % 10007;
        return buffer[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        buffer = new Long[n + 1];

        System.out.println(tileWay(n));

        sc.close();
    }
}