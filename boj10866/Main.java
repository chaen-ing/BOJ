package boj10866;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            switch(str[0]){
                case "push_front" :
                    deque.addFirst(str[1]); // 앞에 삽입
                    break;
                case "push_back" :
                    deque.addLast(str[1]); // 뒤에 삽입
                    break;
                case "pop_front" :
                    if(deque.isEmpty()==true)
                        System.out.println("-1");
                    else{
                        System.out.println(deque.getFirst()); // 앞의 수 출력
                        deque.removeFirst(); // 앞에서 제거
                    }
                    break;
                case "pop_back" :
                    if(deque.isEmpty()==true)
                        System.out.println("-1");
                    else{
                        System.out.println(deque.getLast()); // 뒤의 수 출력
                        deque.removeLast(); // 뒤에서 제거
                    }
                    break;
                case "size" :
                    System.out.println(deque.size()); // 사이즈
                    break;
                case "empty" :
                    if(deque.isEmpty()==true)
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "front" :
                    if(deque.isEmpty()==true)
                        System.out.println("-1");
                    else
                        System.out.println(deque.getFirst());
                    break;
                case "back" :
                    if(deque.isEmpty()==true)
                        System.out.println("-1");
                    else
                        System.out.println(deque.getLast());
                    break;
            }

        }

    }
}
