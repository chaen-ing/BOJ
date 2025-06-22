package boj1259;
import java.io.*;
import java.lang.reflect.Member;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n;
            String str;
            Stack<Character> s = new Stack<>();

            str = br.readLine();
            n = Integer.parseInt(str);
            if (n == 0) break;
            boolean palindromeFlag = true;

            // 한 자리수
            if (str.length() == 1) {
            }
            // 2,3,4,5 자리수
            else {
                for (int i = 0; i < str.length() / 2; i++) {
                    s.push(str.charAt(i));
                }
                if (str.length() % 2 == 0) {   // 짝수 자리수
                    for (int i = str.length() / 2; i < str.length(); i++) {
                        if (s.peek() == str.charAt(i)) s.pop();
                        else {
                            palindromeFlag = false;
                            break;
                        }
                    }
                } else {    // 홀수 자리수
                    for (int i = str.length() / 2 + 1; i < str.length(); i++) {
                        if (s.peek() == str.charAt(i)) s.pop();
                        else {
                            palindromeFlag = false;
                            break;
                        }
                    }
                }
            }
            if(palindromeFlag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}