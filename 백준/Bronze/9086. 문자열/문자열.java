import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 테스트 케이스의 개수 T 입력
        int T = sc.nextInt();

        // 2. T만큼 반복하며 문자열 처리
        for (int i = 0; i < T; i++) {
            String str = sc.next(); // 공백 없는 문자열 입력

            // 첫 글자: 인덱스 0
            char first = str.charAt(0);
            
            // 마지막 글자: 문자열 길이 - 1
            char last = str.charAt(str.length() - 1);

            // 결과 출력 (이어 붙여서 출력)
            System.out.println("" + first + last);
        }
        
        sc.close();
    }
}
