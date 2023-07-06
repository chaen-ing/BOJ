package boj1157;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] counter = new int[26];
        String str = br.readLine();

        char ch;
        for(int i = 0; i < str.length(); i ++){
            ch = str.charAt(i);

            if(ch >='a' && ch <= 'z'){
                counter[ch-97]+=1; // counter[ch-'a']++;
            }
            else if(ch >='A' && ch <= 'Z'){
                counter[ch-65]+=1;
            }
        }

        int max = 0;
        int idx = 0;
        boolean repeated = false;
        for(int j = 0; j < counter.length; j++){
            if(counter[j] == max){
                repeated = true;
            }
            if(counter[j] > max) {
                max = counter[j];
                idx = j;
                repeated = false;
            }
        }

        if(repeated == true)
            System.out.println("?");
        else {
            System.out.println((char)(idx + 65));
        }
    }
}
