import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<int[]> list = new ArrayList();

        for (int i = 0; i < N; i++) {
            int[] arr = new int[2];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            list.add(arr);
        }

        Collections.sort(list,new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]); // 시작 시간 비교
                }
                return Integer.compare(a[1], b[1]); // 끝나는 시간 비교
            }
        });

        int count = 1;
        int x = list.get(0)[1];

        for(int i = 1; i < list.size(); i++){
            int[] current = list.get(i);

            if(current[0] >= x){
                count++;
                x = current[1];
            }
        }

        System.out.println(count);

    }
}
