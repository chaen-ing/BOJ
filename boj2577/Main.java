package boj2577;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        String numStr = Integer.toString(num);

        int [] arr = new int[10];

        for(int i = 0; i < numStr.length(); i++){
            arr[numStr.charAt(i)-'0']++;
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
