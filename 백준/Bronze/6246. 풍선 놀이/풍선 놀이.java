import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 풍선의 수
        int M = sc.nextInt(); // 입력의 수

        boolean[] b = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j <= N; j = j+y) {
                if (!b[j]) {
                    b[j] = true;
                }
            }
        }

        int count = 0;

        for(int i = 1; i <= N; i++) {
            if(!b[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
