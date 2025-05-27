import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];

        for(int i = 0; i < 8; i++){
            arr[i] = sc.nextInt();
        }

        String s = "";
        for(int i = 0; i < 8; i++){
            s += arr[i] + " ";
        }

        if (s.trim().equals("1 2 3 4 5 6 7 8")) {
            System.out.println("ascending");
        }else if (s.trim().equals("8 7 6 5 4 3 2 1")) {
            System.out.println("descending");
        }else {
            System.out.println("mixed");
        }

        sc.close();
    }
}
