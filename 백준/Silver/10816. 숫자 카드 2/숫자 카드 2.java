import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<Integer, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1); // num의 키가 있으면 이전 num값을 가져와서 + 1, 없으면 0에서 + 1
        }

        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            sb.append(cardMap.getOrDefault(target, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());

        sc.close();
    }
}
