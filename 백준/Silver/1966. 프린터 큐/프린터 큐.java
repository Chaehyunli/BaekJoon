import java.util.*;

public class Main {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt(); // 문서의 개수
            int m = sc.nextInt(); // 궁금한 문서의 위치
            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> priorities = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                queue.add(new Document(i, priority));
                priorities.add(priority);
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // 현재 문서의 중요도가 가장 높은가?
                if (current.priority == priorities.peek()) {
                    printOrder++;
                    priorities.poll(); // 인쇄했으므로 제거

                    if (current.index == m) {
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    queue.add(current); // 중요도가 높지 않으므로 뒤로 보냄
                }
            }
        }
    }
}
