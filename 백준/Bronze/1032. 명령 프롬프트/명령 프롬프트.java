import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 파일의 개수 N 입력
        int n = sc.nextInt();
        String[] files = new String[n];

        // 2. 파일 이름들 입력
        for (int i = 0; i < n; i++) {
            files[i] = sc.next();
        }

        // 3. 패턴 찾기 로직
        // 첫 번째 파일 이름을 기준으로 잡고, 문자열을 변경하기 쉽게 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        int len = files[0].length(); // 모든 파일 길이는 같음

        // 각 문자 인덱스(가로)를 순회
        for (int i = 0; i < len; i++) {
            char c = files[0].charAt(i); // 기준 문자는 첫 번째 파일의 i번째 글자
            boolean isSame = true;

            // 나머지 파일들의 i번째 글자와 비교 (세로 비교)
            for (int j = 1; j < n; j++) {
                if (c != files[j].charAt(i)) {
                    isSame = false;
                    break; // 하나라도 다르면 더 볼 필요 없이 ? 확정
                }
            }

            if (isSame) {
                sb.append(c); // 모두 같으면 그 문자 추가
            } else {
                sb.append('?'); // 하나라도 다르면 ? 추가
            }
        }

        // 4. 결과 출력
        System.out.println(sb.toString());
        
        sc.close();
    }
}