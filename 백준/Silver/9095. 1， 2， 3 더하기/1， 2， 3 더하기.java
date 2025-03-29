import java.util.Scanner;

class Main{

    public static int sumWay(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        if(buffer[n] != 0){
            return buffer[n];
        }

        buffer[n] = sumWay(n - 1) + sumWay(n - 2) + sumWay(n - 3);
        return buffer[n];
    }

    static int[] buffer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int input[] = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            input[i] = n;
            max = Math.max(n,max);
        }

        buffer = new int[max + 1]; // 입력받은 n 중 가장 큰 값으면 배열 생성

        for (int i = 0; i < N; i++) {

            System.out.println(sumWay(input[i]));
        }

        sc.close();
    }
}
