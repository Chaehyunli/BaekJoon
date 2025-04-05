import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] words = s.split(" ");
            System.out.println(Integer.parseInt(words[0]) + Integer.parseInt(words[1]));
        }
        sc.close();
    }
}
