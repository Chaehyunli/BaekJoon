import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();
        
        long hash = 0;
        long r = 31;
        long M = 1234567891;
        long power = 1;

        for (int i = 0; i < L; i++) {
            int a = str.charAt(i) - 'a' + 1; // 알파벳을 숫자로 변환: 'a' → 1
            hash = (hash + a * power) % M;
            power = (power * r) % M;
        }

        System.out.println(hash);
    }
}
