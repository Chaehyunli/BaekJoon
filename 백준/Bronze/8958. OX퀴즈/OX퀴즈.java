import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            String[] s = sc.next().split("");
            int count = 0;
            int x = 0;

            for (int j = 0; j < s.length; j++) {
                if(s[j].equals("O")){
                    x++;
                    count = count + x;
                }else {
                    x = 0;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}
