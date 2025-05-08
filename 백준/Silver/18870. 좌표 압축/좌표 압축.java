import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> sortedlist = new ArrayList();

        for (int i = 0; i < N; i++) {
            sortedlist.add(sc.nextInt());
        }

        List<Integer> list = new ArrayList(sortedlist);

        Collections.sort(sortedlist);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int num : sortedlist) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(map.get(num)).append(" ");;
        }

        System.out.println(sb);
        sc.close();

    }
}
