import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

    static class Color {

        String color;
        int value;
        int multiplier;

        Color(String color, int value, int multiplier) {
            this.color = color;
            this.value = value;
            this.multiplier = multiplier;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("black", new Color("black", 0, 1));
        colorMap.put("brown", new Color("brown", 1, 10));
        colorMap.put("red", new Color("red", 2, 100));
        colorMap.put("orange", new Color("orange", 3, 1000));
        colorMap.put("yellow", new Color("yellow", 4, 10000));
        colorMap.put("green", new Color("green", 5, 100000));
        colorMap.put("blue", new Color("blue", 6, 1000000));
        colorMap.put("violet", new Color("violet", 7, 10000000));
        colorMap.put("grey", new Color("grey", 8, 100000000));
        colorMap.put("white", new Color("white", 9, 1000000000));

        String firstColor = sc.nextLine();
        String secondColor = sc.nextLine();
        String thirdColor = sc.nextLine();

        Color c1 = colorMap.get(firstColor);
        Color c2 = colorMap.get(secondColor);
        Color c3 = colorMap.get(thirdColor);

        if (c1 == null || c2 == null || c3 == null) {
            System.out.println("잘못된 색상 입력입니다.");
            sc.close();
            return;
        }

        long result = (c1.value * 10L + c2.value) * c3.multiplier;
        System.out.println(result);
        sc.close();
    }
}
