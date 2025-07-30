import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        // 인접 행렬 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 플로이드–워셜 알고리즘 (경로 존재 여부 판단)
        for (int k = 0; k < n; k++) {         // 중간 경유지
            for (int i = 0; i < n; i++) {     // 시작 노드
                for (int j = 0; j < n; j++) { // 도착 노드
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
