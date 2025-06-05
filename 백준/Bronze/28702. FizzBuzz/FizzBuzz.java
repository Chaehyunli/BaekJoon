import java.util.Scanner;

class Main {

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);  // 또는 Double.parseDouble(str)
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();
        String C = sc.nextLine();

        int x = 0;

        if(isNumeric(A)){
            x = Integer.parseInt(A) + 3;
        }else if(isNumeric(B)){
            x = Integer.parseInt(B) + 2;
        }else if(isNumeric(C)){
            x = Integer.parseInt(C) + 1;
        }

        if(x % 3 == 0){
            if(x % 5 == 0){
                System.out.println("FizzBuzz");
            }else{
                System.out.println("Fizz");
            }
        }else{
            if(x % 5 == 0){
                System.out.println("Buzz");
            }else {
                System.out.println(x);
            }
        }

        sc.close();

    }
}
