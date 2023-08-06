package boj1213;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        int[] alp = new int[26];    // 알파벳의 개수를 저장하는 배열

        for(char ch : arr){
            alp[ch-'A']++;
        }

        char temp = 0;
        int cnt = 0;

        for(int i = 0; i < alp.length; i++){
            if(alp[i] % 2 == 0){    // 짝수일때
                for(int j = 0; j < alp[i]/2; j++){
                    sb.append((char)(i+65)); // 알파벳 출력
                    stack.push((char)(i+65)); // 스택에 넣기
                }
            }

            else if(alp[i] % 2 == 1){    // 홀수 일 때
                temp = (char)(i+65);
                cnt++;

                if(cnt >= 2){   // 홀수인 알파벳이 두개 이상일시 불가능
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }

                if(alp[i] > 1){ // 홀수이면서 3개 이상
                    for(int j = 0; j < alp[i]/2; j++){
                        sb.append((char)(i+65)); // 알파벳 출력
                        stack.push((char)(i+65)); // 스택에 넣기
                    }
                }
            }
        }

        if(cnt==1){
            sb.append(temp);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}
