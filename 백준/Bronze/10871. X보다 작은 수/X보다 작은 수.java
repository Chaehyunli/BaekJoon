import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[N];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if(arr[i] < x){
                res.add(arr[i]);
            }
        }

        for(int i : res){
            System.out.print(i + " ");
        }

        sc.close();
    }
}
