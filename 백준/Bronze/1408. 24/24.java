import java.util.Scanner;

class Main {

    public static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }

    public static String secondsToTime(int seconds) {
        int h = seconds / 3600;
        seconds %= 3600;
        int m = seconds / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String currentTime = sc.nextLine();
        String startTime = sc.nextLine();

        int currentSeconds = timeToSeconds(currentTime);
        int startSeconds = timeToSeconds(startTime);

        int remainingSeconds = (startSeconds - currentSeconds + 86400) % 86400;

        System.out.println(secondsToTime(remainingSeconds));
        sc.close();
    }
}
