import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int maxLen = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < N; right++) {
            int fruit = arr[right];
            freqMap.put(fruit, freqMap.getOrDefault(fruit, 0) + 1);

            while (freqMap.size() > 2) {
                int leftFruit = arr[left];
                freqMap.put(leftFruit, freqMap.get(leftFruit) - 1);
                if (freqMap.get(leftFruit) == 0) {
                    freqMap.remove(leftFruit);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
        
        sc.close();
    }
}
