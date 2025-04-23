import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> defaultList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            String command = parts[0];
            int x = 0;
            if (parts.length > 1) {
                x = Integer.parseInt(parts[1]);
            }

            if(command.equals("add")) {
                list.add(x);
            }else if(command.equals("remove")) {
                if(list.contains(x)) {
                    list.remove((Integer) x);
                }
            }else if(command.equals("check")) {
                sb.append(list.contains(x) ? "1\n" : "0\n");
            }else if(command.equals("toggle")) {
                if(list.contains(x)) {
                    list.remove((Integer) x);
                }else {
                    list.add(x);
                }
            }else if(command.equals("empty")) {
                list.clear();
            }else if(command.equals("all")) {
                list.clear();
                list.addAll(defaultList);
            }
        }

        System.out.println(sb);

        sc.close();
    }
}
