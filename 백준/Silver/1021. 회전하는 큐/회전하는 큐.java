import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 큐의 크기, M: 뽑아내려는 수의 개수
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 1부터 N까지 담을 LinkedList 생성
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        // 뽑아내려는 수들의 위치(순서)
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        int count = 0; // 2, 3번 연산 횟수 누적

        for (int i = 0; i < M; i++) {
            int target = targets[i];
            
            // 현재 리스트에서 타겟 숫자의 위치(인덱스) 찾기
            int targetIdx = list.indexOf(target);
            
            // 현재 리스트의 중간 지점 계산 (짝수일 경우 앞쪽이 중간에 포함된다고 가정)
            int halfIdx;
            if (list.size() % 2 == 0) {
                halfIdx = list.size() / 2 - 1;
            } else {
                halfIdx = list.size() / 2;
            }

            // 왼쪽으로 이동할지 오른쪽으로 이동할지 결정 (Greedy)
            if (targetIdx <= halfIdx) {
                // 왼쪽으로 이동 (2번 연산)
                // 타겟이 맨 앞으로 올 때까지 반복
                for (int j = 0; j < targetIdx; j++) {
                    int temp = list.pollFirst();
                    list.addLast(temp);
                    count++;
                }
            } else {
                // 오른쪽으로 이동 (3번 연산)
                // 타겟이 맨 앞으로 올 때까지 반복
                for (int j = 0; j < list.size() - targetIdx; j++) {
                    int temp = list.pollLast();
                    list.addFirst(temp);
                    count++;
                }
            }
            
            // 1번 연산: 원소 뽑아내기 (항상 맨 앞에서 뽑음)
            list.pollFirst();
        }

        System.out.println(count);
    }
}