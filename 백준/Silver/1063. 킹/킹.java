import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 받기
        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        // 2. 좌표 변환 (문자열 -> 0~7 인덱스)
        // A=0, B=1 ... H=7 (열, X)
        // 1=0, 2=1 ... 8=7 (행, Y)
        int kx = kingPos.charAt(0) - 'A';
        int ky = kingPos.charAt(1) - '1';
        int sx = stonePos.charAt(0) - 'A';
        int sy = stonePos.charAt(1) - '1';

        // 3. 이동 명령 처리
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            int dx = 0;
            int dy = 0;

            // 이동 방향 설정
            switch (command) {
                case "R": dx = 1; dy = 0; break;
                case "L": dx = -1; dy = 0; break;
                case "B": dx = 0; dy = -1; break;
                case "T": dx = 0; dy = 1; break;
                case "RT": dx = 1; dy = 1; break;
                case "LT": dx = -1; dy = 1; break;
                case "RB": dx = 1; dy = -1; break;
                case "LB": dx = -1; dy = -1; break;
            }

            // 킹의 예상 위치
            int nextKx = kx + dx;
            int nextKy = ky + dy;

            // 1) 킹이 체스판 밖으로 나가는지 확인
            if (isOutOfBoard(nextKx, nextKy)) {
                continue; // 이동 건너뜀
            }

            // 2) 킹이 돌의 위치로 이동하는지 확인
            if (nextKx == sx && nextKy == sy) {
                // 돌의 예상 위치
                int nextSx = sx + dx;
                int nextSy = sy + dy;

                // 돌이 체스판 밖으로 나가는지 확인
                if (isOutOfBoard(nextSx, nextSy)) {
                    continue; // 돌이 나가면 킹도 이동 안 함
                }

                // 돌 위치 업데이트
                sx = nextSx;
                sy = nextSy;
            }

            // 킹 위치 업데이트 (돌이 없거나, 돌을 성공적으로 밀었을 때)
            kx = nextKx;
            ky = nextKy;
        }

        // 4. 결과 출력 (인덱스 -> 문자열 변환)
        StringBuilder sb = new StringBuilder();
        sb.append((char) (kx + 'A')).append((char) (ky + '1')).append("\n");
        sb.append((char) (sx + 'A')).append((char) (sy + '1'));

        System.out.println(sb);
    }

    // 체스판 범위(0~7)를 벗어나는지 확인하는 함수
    public static boolean isOutOfBoard(int x, int y) {
        return x < 0 || x >= 8 || y < 0 || y >= 8;
    }
}