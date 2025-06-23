package boj11720;
import java.io.*;

public class Main {
    public static void main(String[]args) throws IOException{
        //firstSolve();
        secondSolve();
    }

    private static void firstSolve() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String str = br.readLine();

        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            sum += str.charAt(i) - '0';
        }

        System.out.println(sum);
    }

    private static void secondSolve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        char [] arr = str.toCharArray();

        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i] - '0';
        }

        System.out.println(sum);

    }

}
