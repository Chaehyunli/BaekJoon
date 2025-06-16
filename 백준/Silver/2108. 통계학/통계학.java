import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        Map<Integer, Integer> freqMap = new HashMap<>();

        int sum = 0;
        int min = 4001;
        int max = -4001;

        // 입력 처리
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            sum += num;

            // 최댓값, 최솟값 갱신
            if (num < min) min = num;
            if (num > max) max = num;

            // 빈도수 기록
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 정렬 (중앙값, 최빈값 순위 정할 때 사용)
        Arrays.sort(numbers);

        // 최빈값 계산
        int maxFreq = 0;
        List<Integer> modeList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int value = entry.getValue();
            if (value > maxFreq) {
                maxFreq = value;
                modeList.clear();
                modeList.add(entry.getKey());
            } else if (value == maxFreq) {
                modeList.add(entry.getKey());
            }
        }

        // 정렬해서 두 번째로 작은 최빈값을 선택
        Collections.sort(modeList);
        int mode = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0);

        // 산술평균 반올림
        int avg = (int) Math.round((double) sum / N);

        // 출력
        System.out.println(avg);              // 산술평균
        System.out.println(numbers[N / 2]);   // 중앙값
        System.out.println(mode);             // 최빈값
        System.out.println(max - min);        // 범위
    }
}
