import java.util.Scanner;

class Main {

    public static boolean isRightEngle(int a, int b, int c){
        int max = Math.max(a,Math.max(b,c));

        if(max == a & (a*a == b*b + c*c)){
            return true;
        }

        if(max == b & (b*b == c*c + a*a)){
            return true;
        }

        if(max == c & (c*c == b*b + a*a)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if((a==0)&&(b==0)&&(c==0)){
                break;
            }

            if(isRightEngle(a,b,c)){
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }
        }
    }
}
