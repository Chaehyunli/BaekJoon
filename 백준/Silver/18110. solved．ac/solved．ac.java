import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());;
        }

        Arrays.sort(arr);

        long size = Math.round(N * 0.15);

        float sum = 0;

        for(int i = 1 + (int)size; i <= N - size; i++){
            sum += arr[i];
        }

        System.out.println(Math.round(sum / (N - 2 * size)));
    }
}
