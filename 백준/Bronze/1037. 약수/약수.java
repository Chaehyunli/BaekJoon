import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 약수의 개수 입력 (사실 계산에는 크게 필요 없지만 입력 형식을 맞추기 위함)
        int count = sc.nextInt();

        // 2. 최솟값과 최댓값을 저장할 변수 초기화
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 3. 약수들을 입력받으며 최솟값과 최댓값 갱신
        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // 4. 결과 출력 (최솟값 * 최댓값)
        System.out.println(min * max);
        
        sc.close();
    }
}