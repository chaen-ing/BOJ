package boj11656;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String [] arr = new String[str.length()];   // string 담는 배열

        // 문자열 담기
        for(int i = 0; i < str.length(); i++){
            arr[i] = str.substring(i,str.length());
        }

        // 정렬
        Arrays.sort(arr);

        for(int i = 0; i < str.length(); i++){
            System.out.println(arr[i]);
        }
    }
}
