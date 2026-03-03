import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int line = 1;
        while(N > line){
            N -= line;
            line++;
        }

        int num;
        int deno;

        if(line % 2 == 1){
            num = line - N + 1;
            deno = N;
        }else{
            num = N;
            deno = line - N + 1;
        }

        System.out.println(num + "/" + deno);

    }
}
