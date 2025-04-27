import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> setN = new HashSet<>();
        Set<String> setM = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            setN.add(sc.next());
        }

        for (int i = 1; i <= M; i++) {
            setM.add(sc.next());
        }

        Set<String> intersection = new HashSet<>(setN);
        intersection.retainAll(setM); // 해쉬셋은 순서가 없기 때문에, 리스트로 바꾼 후 정렬함.

        List<String> list = new ArrayList<>(intersection);

        Collections.sort(list);

        System.out.println(list.size());

        for(String item: list){
            System.out.println(item);
        }

        sc.close();
    }
}
