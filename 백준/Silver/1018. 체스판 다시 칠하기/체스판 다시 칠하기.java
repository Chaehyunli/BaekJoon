import java.util.Scanner;

class Main {
    static char[][] board;

    public static int countRepaints(int x, int y) {
        int whiteFirst = 0; // (x, y)가 W로 시작하는 경우
        int blackFirst = 0; // (x, y)가 B로 시작하는 경우

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[x + i][y + j]; // (x, y) 가 시작 위치
                // 짝수 인덱스 합이면 시작 색과 같아야 함
                if ((i + j) % 2 == 0) {
                    if (current != 'W') whiteFirst++;
                    if (current != 'B') blackFirst++;
                } else {
                    if (current != 'B') whiteFirst++;
                    if (current != 'W') blackFirst++;
                }
            }
        }

        return Math.min(whiteFirst, blackFirst);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열
        sc.nextLine(); // 개행문자 처리

        board = new char[N][M];

        // 보드 입력
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            board[i] = line.toCharArray();
        }

        int minRepaints = Integer.MAX_VALUE;

        // 가능한 모든 8x8 시작 위치 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaintCount = countRepaints(i, j); // 보드의 시작 위치를 넘겨줌
                minRepaints = Math.min(minRepaints, repaintCount);
            }
        }

        System.out.println(minRepaints);
        sc.close();
    }
}
