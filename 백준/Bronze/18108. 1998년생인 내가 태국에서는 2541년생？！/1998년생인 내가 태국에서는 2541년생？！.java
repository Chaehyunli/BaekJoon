import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 불기 연도 입력
        int buddhaYear = sc.nextInt();

        // 서기 연도로 변환
        int commonYear = buddhaYear - 543;

        // 출력
        System.out.println(commonYear);
    }
}
