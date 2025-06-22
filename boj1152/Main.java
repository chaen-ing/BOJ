package boj1152;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        String[] arr = str.split(" ");
        if(arr[0].equals("")){
            System.out.println(0);
        }
        else{
            System.out.println(arr.length);
        }
    }
}
