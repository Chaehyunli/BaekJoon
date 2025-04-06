import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int h = sc.nextInt(); // 층 수
            int w = sc.nextInt(); // 한 층의 방 수
            int n = sc.nextInt(); // 몇 번째 손님

            int floor; // 층수
            int room;  // 호수

            if (n % h == 0) {
                floor = h;
                room = n / h;
            } else {
                floor = n % h;
                room = n / h + 1;
            }

            System.out.printf("%d%02d\n", floor, room);
        }

        sc.close();
    }
}
