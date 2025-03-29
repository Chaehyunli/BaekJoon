import java.util.Scanner;

class Main {

    public static int[] calculateNum(int n){
        int[] answer = new int[2];
        if(n == 0){
            answer[0] = 1;
            return answer;
        }
        if(n == 1){
            answer[1] = 1;
            return answer;
        }

        if((bufferA[n] != 0) && (bufferB[n] != 0)){
            answer[0] = bufferA[n];
            answer[1] = bufferB[n];
            return answer;
        }

        bufferA[n] = calculateNum(n-1)[0] + calculateNum(n-2)[0];
        bufferB[n] = calculateNum(n-1)[1] + calculateNum(n-2)[1];

        answer[0] = bufferA[n];
        answer[1] = bufferB[n];

        return answer;
    }

    static int[] bufferA;
    static int[] bufferB;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            input[i] = n;
            max = Math.max(n,max);
        }

        bufferA = new int[max + 1]; // 입력받은 n 중 가장 큰 값으면 배열 생성
        bufferB = new int[max + 1];

        for (int i = 0; i < N; i++) {

            System.out.println(calculateNum(input[i])[0] + " " + calculateNum(input[i])[1]);
        }

        sc.close();
    }
}

