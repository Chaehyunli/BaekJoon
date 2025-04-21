import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 전체 참가자 수
        int a = sc.nextInt(); // 첫번째 사람의 번호
        int b = sc.nextInt(); // 두번째 사람의 번호

        int totalRound = (int) (Math.log(n) / Math.log(2));

        int round = 1;
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            if (a != b) round++;
        }

        System.out.println(round);

        sc.close();
    }
}
