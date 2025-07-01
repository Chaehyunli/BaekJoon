import java.util.Scanner;

class Main {
    // 위로 정렬 (insert 시 사용)
    private static void heapifyUp(int[] heap, int index) {
        while (index > 1 && heap[index] > heap[index / 2]) {
            swap(heap, index, index / 2);
            index /= 2;
        }
    }

    // 아래로 정렬 (remove 시 사용)
    private static void heapifyDown(int[] heap, int size, int index) {
        while (index * 2 <= size) {
            int left = index * 2;
            int right = index * 2 + 1;
            int larger = left;

            if (right <= size && heap[right] > heap[left]) {
                larger = right;
            }

            if (heap[index] >= heap[larger]) {
                break;
            }

            swap(heap, index, larger);
            index = larger;
        }
    }

    private static void swap(int[] heap, int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // -> 최대 힙. offer(a), peek(), isEmpty() 사용 가능
        int N = sc.nextInt();

        int[] heap = new int[N + 1];
        int size = 0;

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();

            if(input == 0) {
                if (size == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(heap[1]); // 항상 heap[1]이 최댓값
                    heap[1] = heap[size--];
                    heapifyDown(heap, size, 1); // 맨 아래값을 root로 올렸으니 다시 정렬
                }
            }else {
                size++;
                heap[size] = input;
                heapifyUp(heap, size);
            }

        }

        sc.close();
    }
}
