package boj10828;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>(); //stack 선언

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String []str = br.readLine().split(" ");

            if(str[0].equals("push")){
                stack.push(Integer.parseInt(str[1])); //stack.push 값 넣는 메소드
            }

            else if(str[0].equals("top")){
                if(stack.isEmpty()==true){ // stack.isEmpty 공백스택인지 확인하는 메소드
                    System.out.println("-1");
                }
                else
                    System.out.println(stack.peek());
            }

            else if(str[0].equals("size")){
                System.out.println(stack.size()); // 스택에 있는 값 개수 확인
            }

            else if(str[0].equals("pop")){
                if (stack.isEmpty()==true){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.peek()); // top에 있는 값 확인하는 메소드
                    stack.pop(); // top에 있는 값 꺼내는 메소드
                }
            }
            else{ //empty 경우
                if(stack.isEmpty()==true){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
        }
    }
}