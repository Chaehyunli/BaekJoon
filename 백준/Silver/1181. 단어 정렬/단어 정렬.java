import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 버퍼 제거

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            if(!words.contains(s)){
                words.add(s);
            }
        }

        words.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length(); // 길이 오름차순
            } else {
                return s1.compareTo(s2); // 같으면 사전순
            }
        });


        for (String word : words) {
            System.out.println(word);
        }
    }
}
