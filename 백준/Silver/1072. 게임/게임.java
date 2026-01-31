import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = (y * 100) / x;
        
        // 승률이 99% 이상이면 절대 변하지 않음
        if (z >= 99) {
            System.out.println(-1);
            return;
        }
        
        long low = 1;
        long high = 1000000000;
        long answer = -1;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long nextZ = ((y + mid) * 100) / (x + mid);
            
            if (nextZ > z) {
                // 승률이 올랐다면, 더 적은 횟수로도 가능한지 확인
                answer = mid;
                high = mid - 1;
            } else {
                // 승률이 그대로라면, 횟수를 늘려야 함
                low = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}