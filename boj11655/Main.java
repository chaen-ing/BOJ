package boj11655;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            // 숫자 또는 공백
            if((c >= '0' && c <= '9')||(c == ' '))
                sb.append(c);
            // 알파벳
            else{
                // 소문자
                if(c >= 'a' && c <= 'z'){
                    if(c + 13 > 'z')
                        sb.append((char)(c - 13));
                    else
                        sb.append((char)(c + 13));
                }
                // 대문자
                else{
                    if(c + 13 > 'Z')
                        sb.append((char)(c - 13));
                    else
                        sb.append((char)(c + 13));
                }
            }

        }

        System.out.println(sb);


    }
}
