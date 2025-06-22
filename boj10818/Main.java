package boj10818;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        String nums = br.readLine();
        String[] arr = nums.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < Integer.parseInt(n) ;i++){
            int a = Integer.parseInt(arr[i]);
            if(a > max){
                max = a;
            }
            if(a < min){
                min = a;
            }
        }

        System.out.printf("%d %d",min,max);

    }
}

