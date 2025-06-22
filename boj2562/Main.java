package boj2562;
import java.io.*;

public class Main {
    public static void main(String[]args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int order = 0;

        for(int i = 1; i <= 9; i++){
            int n = Integer.parseInt(br.readLine());
            if(n > max){
                max = n;
                order = i;
            }
        }

        System.out.println(max);
        System.out.println(order);

    }
}