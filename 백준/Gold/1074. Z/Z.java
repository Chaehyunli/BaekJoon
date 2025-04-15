import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextInt();
        long r = sc.nextInt();
        long c = sc.nextInt();
        long result = 0;

        long[][] arr = {{0,1},{2,3}};

        while(N > 1){

            if(r >= Math.pow(2,N-1)){
                r = r - (long) Math.pow(2,N-1);
                result = result + (long) Math.pow(2,2*N-1);
            }

            if (c >= Math.pow(2,N-1)) {
                c = c - (long) Math.pow(2,N-1);
                result = result + (long) Math.pow(2,2*N-2);
            }

            N--;
        }

        result = result + arr[(int)r][(int)c];

        System.out.println(result);

        sc.close();
    }
}
