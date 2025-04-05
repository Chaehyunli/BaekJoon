import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int[] buf = new int[9];
        int max = 0;

        for (int i = 0; i < 9; i++) {
            int a = sc.nextInt();
            buf[i] = a;
            if(buf[i] > max){
                max = buf[i];
                count = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(count);

        sc.close();
    }
}
