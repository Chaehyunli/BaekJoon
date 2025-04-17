import java.util.Scanner;

class Main {

    static int num = 0;
    //static List<Pair> moves = new ArrayList<>();  // 이동 경로 저장용 리스트
    static StringBuilder sb = new StringBuilder();

    // 정수 쌍을 저장할 Pair 클래스 정의
    static class Pair {
        int from, to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    // 하노이의 탑 재귀 함수
    public static void hanoi(int n, int from, int mid, int to) {
        if (n == 1) {
            //moves.add(new Pair(from, to));
            sb.append(from).append(" ").append(to).append("\n");
            num++;
            return;
        }

        num++;
        hanoi(n - 1, from, to, mid); // n-1 개를 1에서 2로 옮기기

        //moves.add(new Pair(from, to)); // 가장 큰 원판을 1에서 3으로 옮기기
        sb.append(from).append(" ").append(to).append("\n");

        hanoi(n - 1, mid, from, to); // n-1개를 2에서 3으로 옮기기
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        hanoi(n, 1, 2, 3); // hanoi(n, from, mid, to)

        System.out.println(num);
        System.out.print(sb);

//        for (Pair move : moves) {
//            System.out.println(move.from + " " + move.to);
//        }

        sc.close();
    }
}
