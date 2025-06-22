package boj1546;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        double [] scores = new double[N];

        st = new StringTokenizer(br.readLine());

        double max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, scores[i]);
        }

        double sum = 0;
        for(int i = 0; i < N; i++){
            scores[i] = scores[i] / max * 100.0;
            sum += scores[i];
        }

        System.out.println(sum/N);

    }
}
