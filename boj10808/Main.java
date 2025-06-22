package boj10808;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [] alp = new int[26];

        String str =  br.readLine();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            alp[c-97]++;
        }

        for(int i : alp){
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

}
