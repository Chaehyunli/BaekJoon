import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        numbers.sort((a,b) -> a - b);

        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num).append('\n');
        }

        System.out.print(sb);

    }
}
