package boj10820;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // str에서 소문자, 대문자, 숫자, 공백 개수를 순서대로 출력
        while(str != null){
            int [] cnt = {0,0,0,0};

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                // 소문자
                if (c >= 'a' && c <= 'z')
                    cnt[0]++;
                // 대문자
                else if(c >= 'A' && c <= 'Z')
                    cnt[1]++;
                // 숫자
                else if(c >= '0' && c <= '9')
                    cnt[2]++;
                // 공백
                else
                    cnt[3]++;
            }

            for(int i = 0; i < 4; i++){
                System.out.print(cnt[i]+" ");
            }

            System.out.print("\n");
            str = br.readLine();
        }

    }

}
