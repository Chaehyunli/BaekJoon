import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1/6/12/18/24
        int rank = 1;

        while (true){
            int max = 3 * rank * rank - 3 * rank + 1;
            if(N > max){
                rank++;
            }else {
                break;
            }
        }

        System.out.println(rank);
    }
}
