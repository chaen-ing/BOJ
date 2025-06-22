package boj10799;
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();

        char [] arr = br.readLine().toCharArray();

        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            // '('의 경우
            if(arr[i] == '('){
                s.push(arr[i]);
                cnt++;
            }
            // ')'의 경우
            else{
                s.pop();
                // 레이저인 경우
                if(arr[i-1] == '('){
                    cnt--;
                    cnt += s.size();
                }
            }
        }

        System.out.println(cnt);

    }
}
