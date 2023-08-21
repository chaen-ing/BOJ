package boj17413;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack <Character> s = new Stack<>();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            // 공백문자가 나올 경우 큐를 비워줌
            if(str.charAt(i) == ' '){
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
                sb.append(' ');
            }

            // 태그가 나올 경우 <> 사이 문자 그대로 출력
            else if(str.charAt(i) == '<'){
                // 태그 전에 스택에 쌓인 문자가 있을 경우
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
                while(!(str.charAt(i) == '>')){
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append('>');
            }
            else
                s.push(str.charAt(i));
        }

        // 마지막에 스택에 남은 문자가 있다면 출력
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        System.out.println(sb);
    }
}
