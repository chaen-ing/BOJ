package boj9012;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            Stack<Character> stack = new Stack<>();
            char [] arr;
            arr = br.readLine().toCharArray();

            boolean validString = true;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == '('){
                    stack.push('(');
                }
                else{
                    if(stack.isEmpty()){
                        validString = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty() || validString == false)
                System.out.println("NO");
            else
                System.out.println("YES");

        }


    }
}
