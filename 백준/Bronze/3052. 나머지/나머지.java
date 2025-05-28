import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<10; i++){
            int x = sc.nextInt();
            int X = x % 42;

            if(!map.containsKey(X)){
                map.put(X, 1);
            }else {
                map.put(X, map.get(X)+1);
            }
        }

        System.out.println(map.size());

        sc.close();
    }
}
