import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 참가자 수

        int[] Tsize = new int[6];
        int count =0;

        for (int i = 0; i < 6; i++) {
            Tsize[i] = sc.nextInt();
            count += Tsize[i];
        }

        if(count != N){
            return;
        }

        int T = sc.nextInt();
        int P = sc.nextInt();

        int Tresult = 0;
        int[] Presult = new int[2];

        for (int i = 0; i < 6; i++) {
            if(Tsize[i] % T == 0) {
                Tresult += Tsize[i] / T;
            }else {
                Tresult += Tsize[i] / T + 1;
            }
        }

        Presult[0] = N / P;
        Presult[1] = N % P;

        System.out.println(Tresult);
        System.out.println(Presult[0] + " " + Presult[1]);

        sc.close();

    }
}
