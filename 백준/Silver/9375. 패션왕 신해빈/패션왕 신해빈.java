import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            Map<String, Integer> map = new HashMap<>();

            for(int j = 0; j < a; j++) {
                String[] s = sc.nextLine().split(" ");
                map.put(s[1], map.getOrDefault(s[1], 0) + 1);
            }

            int result = 1;

            for(int count : map.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
        }

    }
}
