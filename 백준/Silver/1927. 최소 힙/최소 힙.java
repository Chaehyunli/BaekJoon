import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            if(x == 0){
                if(minHeap.isEmpty()){
                    sb.append("0").append("\n");
                }else{
                    sb.append(minHeap.poll()).append("\n");
                }
            }else {
                minHeap.add(x);
            }
        }

        System.out.println(sb);
    }
}
