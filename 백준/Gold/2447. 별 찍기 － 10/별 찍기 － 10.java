import java.util.Scanner;

class Main {

    // 재귀적으로 별 패턴을 생성
    public static String[] drawSquare(int n) {
        if (n == 3) {
            return new String[] {
                "***",
                "* *",
                "***"
            };
        }

        String[] small = drawSquare(n / 3);
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = ""; // 한 줄 초기화
        }

        for (int i = 0; i < 3; i++) { // 블록 행
            for (int j = 0; j < 3; j++) { // 블록 열
                for (int k = 0; k < n / 3; k++) {
                    if (i == 1 && j == 1) {
                        // 가운데 블록은 공백으로 채움
                        result[i * (n / 3) + k] += " ".repeat(n / 3);
                    } else {
                        // 그 외에는 작은 패턴 복사
                        result[i * (n / 3) + k] += small[k];
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 3의 거듭제곱 입력

        String[] pattern = drawSquare(N);

        for (String line : pattern) {
            System.out.println(line);
        }

        sc.close();
    }
}
