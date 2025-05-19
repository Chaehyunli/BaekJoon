import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] A = sc.next().split("");
        String[] B = sc.next().split("");

        long result = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                result = result + (long) Integer.parseInt(A[i]) * Integer.parseInt(B[j]);
            }
        }

        System.out.println(result);
        
        sc.close();

    }
}
