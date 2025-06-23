import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[5];

        for(int i = 0; i < 5; i++){

            int score = sc.nextInt();

            if(score < 40){
                score = 40;
            }
            scores[i] = score;
        }

        int sum = 0;

        for(int i = 0; i < 5; i++){
            sum += scores[i];
        }

        System.out.println(sum/5);

        sc.close();
    }
}
