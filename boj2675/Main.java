package boj2675;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            String[] arr = str.split("");

            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < n; j++){
                    sb.append(arr[i]);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
