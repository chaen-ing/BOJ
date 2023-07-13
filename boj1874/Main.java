package boj1874;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int top = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > top) {
                for (int j = top+ 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                top = num;
            } else {
                if (stack.peek() != num) {
                    System.out.println("No");
                    return;
                }
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}