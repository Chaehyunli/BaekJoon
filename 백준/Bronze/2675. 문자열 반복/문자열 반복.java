import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            String s = sc.next();
            String result = "";
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < x; k++) {
                    result += String.valueOf(s.charAt(j));
                }
            }
            System.out.println(result);
        }

        sc.close();
    }
}
