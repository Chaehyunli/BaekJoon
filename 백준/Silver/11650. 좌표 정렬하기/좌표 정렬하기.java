import java.util.ArrayList;
import java.util.Scanner;

class Dot{
    int x; // x 좌표
    int y; // y 좌표

    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Dot> dots = new ArrayList<Dot>();

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            dots.add(new Dot(x, y));
        }

        dots.sort((d1, d2) -> {
            if(d1.x != d2.x){
                return d1.x - d2.x;
            }else{
                return d1.y - d2.y;
            }
        });

        for(Dot d : dots){
            System.out.println(d.x + " " + d.y);
        }

        sc.close();
    }
}
