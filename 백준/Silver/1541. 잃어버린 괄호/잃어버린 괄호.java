import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // "+" 로 나눠 각 숫자를 더하는 함수
    private static int sumSegment(String segment) {
        String[] numbers = segment.split("\\+");
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine().trim();

        // '-' 기준으로 먼저 나누기
        String[] parts = expression.split("-");

        // 첫 번째 부분은 그대로 더하기
        int result = sumSegment(parts[0]);

        // 두 번째부터는 각각 더해서 빼기
        for (int i = 1; i < parts.length; i++) {
            result -= sumSegment(parts[i]);
        }

        System.out.println(result);
    }
}
