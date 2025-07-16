import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> map = new HashMap<>();

        // P개의 사이트 주소와 비밀번호 저장
        for (int i = 0; i < P; i++) {
            String line = sc.nextLine(); // "site password"
            String[] parts = line.split(" ");
            String site = parts[0];
            String password = parts[1];
            map.put(site, password);
        }

        // N개의 사이트 주소에 대해 비밀번호 출력
        for (int i = 0; i < N; i++) {
            String siteToFind = sc.nextLine();
            System.out.println(map.get(siteToFind));
        }

        sc.close();
    }
}
