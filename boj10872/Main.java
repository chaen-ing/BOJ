package boj10872;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int fact = n;

        if(fact == 0)
            System.out.println(1);
        else{
            while(n-->1){
                fact *= n;
            }
            System.out.println(fact);
        }

    }
}
