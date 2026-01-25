import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        
        // Integer.bitCount는 정수를 이진수로 표현했을 때 1의 개수를 반환합니다.
        System.out.println(Integer.bitCount(X));
        
        sc.close();
    }
}