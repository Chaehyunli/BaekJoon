import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Long> decreasingNumbers = new ArrayList<>();

        // 0~9까지 한 자리 수로 시작해서 감소하는 수 만들기
        Queue<Long> queue = new LinkedList<>();
        for (int i = 0; i <= 9; i++) {
            queue.offer((long) i); // 0, 1, 2, 3, 4, 5, 6 ...
        }

        while (!queue.isEmpty()) {
            long current = queue.poll();
            decreasingNumbers.add(current);

            long lastDigit = current % 10; // current 가 532 이라면
            for (int i = 0; i < lastDigit; i++) {
                long next = current * 10 + i; // 5321, 5320 이 큐에 들어감
                queue.offer(next);
            }
        }

        // 정렬은 사실상 필요 없음 (오름차순으로 들어가기 때문), 그래도 안전하게 정렬
        Collections.sort(decreasingNumbers);

        if (N < decreasingNumbers.size()) {
            System.out.println(decreasingNumbers.get(N));
        } else {
            System.out.println(-1);
        }
    }
}
