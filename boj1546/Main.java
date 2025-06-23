package boj1546;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String []args)throws IOException{
        //firstSolve();
        secondSolve();
    }

    private static void firstSolve() throws IOException {
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

    private static void secondSolve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double max = Arrays.stream(arr).max().orElse(0);
        double sum = Arrays.stream(arr).sum();

        System.out.println(sum / max * 100.0 / (double)N);

    }
}
