import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int)(max - min + 1);
        boolean[] isNotSquareFree = new boolean[size];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = ((min + square - 1) / square) * square;

            for (long j = start; j <= max; j += square) {
                isNotSquareFree[(int)(j - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!isNotSquareFree[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
