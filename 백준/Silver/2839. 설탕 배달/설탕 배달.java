import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int result = -1;

        // 5kg 봉지 개수부터 줄여가며 시도
        for (int i = N / 5; i >= 0; i--) {
            int rest = N - (5 * i);

            if (rest % 3 == 0) {
                int j = rest / 3;
                result = i + j;
                break; // 최소 개수 찾으면 바로 종료
            }
        }

        System.out.println(result);
    }
}
