import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            list.add(a);
        }

        int[] index = new int[n];
        for (int i = 0; i < list.size(); i++) {
            index[i] = i + 1;
        }

        Collections.sort(list);
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) * index[i];
        }

        System.out.println(result);

    }
}
