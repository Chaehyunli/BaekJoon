import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");

        int missingIndex = -1;
        int[] weights = {1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3}; // 앞 12자리만
        int total = 0;

        for (int i = 0; i < 12; i++) {
            if (s[i].equals("*")) {
                missingIndex = i;
                continue;
            }
            total += Integer.parseInt(s[i]) * weights[i];
        }

        int checkDigit = Integer.parseInt(s[12]); // 마지막 m

        for (int x = 0; x <= 9; x++) {
            int candidateTotal = total + x * weights[missingIndex];
            if ((candidateTotal + checkDigit) % 10 == 0) {
                System.out.println(x);
                break;
            }
        }

        sc.close();
    }
}
