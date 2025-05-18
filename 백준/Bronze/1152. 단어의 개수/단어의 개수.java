import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();

        if (str.isEmpty()) {
            System.out.println(0);  // 공백만 입력되었을 경우
        } else {
            String[] words = str.split(" ");
            System.out.println(words.length);
        }

        sc.close();
    }
}
