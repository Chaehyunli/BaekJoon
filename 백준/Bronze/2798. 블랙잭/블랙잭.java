import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드의 개수 N
        int M = sc.nextInt(); // 목표 카드의 합 M

        int[] cardList = new int[N]; // N개의 카트의 목록

        for (int i = 0; i < N; i++) {
            cardList[i] = sc.nextInt();
        }

        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    sum = cardList[i] + cardList[j] + cardList[k];
                    if(sum < M) {
                        if(max < sum) {
                            max = sum;
                        }
                    }else if(sum == M){
                        max = sum;
                        System.out.println(max);
                        return;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
