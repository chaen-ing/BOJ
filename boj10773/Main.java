package boj10773;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> s = new Stack<>();
        int sum = 0;
        int K = Integer.parseInt(br.readLine());

        while(K-->0){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                sum -= s.pop();
            }else{
                s.push(n);
                sum += n;
            }
        }

        System.out.println(sum);
    }
}
