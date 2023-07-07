package boj10809;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int []idx = new int[26];

        // 배열 -1로 초기화
        for(int i = 0; i < idx.length; i++){
            idx[i] = -1;
        }

        // 알파벳 소문자 97 ~ 122 -> 0 ~ 26
        for(int j = 0; j < str.length(); j++){
            char ch = str.charAt(j); // b 저장
            if(idx[ch - 97] != -1){
                continue;
            }
            else{
                idx[ch - 97] = j;//idx의 1번에
            }
        }

        // 출력
        for(int k = 0; k < idx.length; k++){
            System.out.print(idx[k]+" ");
        }
    }
}
