import java.util.*;

class Main {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static List<Integer> getDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i != 1) divisors.add(i);
                divisors.add(n / i);
            }
        }

        List<Integer> result = new ArrayList<>(divisors);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {

        // 입력의 차의 배열을 구한 후, 그 배열들의 최대공약수를 구함.
        // 최대공약수의 1을 제외한 약수들이 정답 M
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }

        int[] subarr = new int[n-1]; // 각 arr의 차이를 저장하는 배열

        for (int i = 0; i < subarr.length; i++) {
            subarr[i] = Math.abs(arr[i+1]- arr[i]);
        }

        List<Integer> divisors = getDivisors(gcd(subarr));

        StringBuilder sb = new StringBuilder();

        for (int d : divisors) {
            sb.append(d).append(" ");
        }

        System.out.println(sb);
        sc.close();
    }
}
