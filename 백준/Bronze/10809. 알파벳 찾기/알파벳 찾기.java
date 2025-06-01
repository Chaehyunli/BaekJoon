import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], -1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) & map.get(c) == -1) {
                map.put(c, i);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(map.get(chars[i]) + " ");
        }
        
        sc.close();

    }
}
