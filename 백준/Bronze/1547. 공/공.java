import java.util.Scanner;

class Main {

    static boolean[] cup = new boolean[]{true,false,false};

    public static void move(int a, int b){

        boolean temp = cup[a-1];
        cup[a-1] = cup[b-1];
        cup[b-1] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            move(a,b);
        }

        for (int i = 0; i < cup.length; i++) {
            if(cup[i]){
                System.out.println(i+1);
            }
        }
    }
}
