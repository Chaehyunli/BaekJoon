import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr1[i] = a;
            arr2[i] = b;
        }

        for (int i = 0; i < N; i++) {
            int num = 1;
            for (int j = 0; j < N; j++) {
                if (arr1[i] < arr1[j] && arr2[i] < arr2[j]) {
                    num++;
                }
            }
            System.out.print(num + " ");
        }

        sc.close();
    }
}
