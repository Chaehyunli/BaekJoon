import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String n = sc.nextLine();
            if(n.equals("0")) break;

            int len = n.length();
            boolean flag = true;

            for (int i = 0; i < len / 2; i++) {
                char a = n.charAt(i);
                char b = n.charAt(len - i - 1);
                if(a != b){
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
