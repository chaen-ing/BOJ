package boj10845;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
// 큐 : 선입선출
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int back = 0;
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("push")) {
                queue.add(Integer.parseInt(str[1])); // 삽입
                back = Integer.parseInt(str[1]);
            } else if (str[0].equals("pop")) {
                if (queue.isEmpty()) // 공백이면 true
                    System.out.println("-1");
                else {
                    System.out.println(queue.peek()); // peek : front 값 반환
                    queue.poll();
                }
            } else if (str[0].equals("size")) {
                System.out.println(queue.size()); // 큐의 크기 반환
            } else if (str[0].equals("empty")) {
                if (queue.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
            } else if (str[0].equals("front")) {
                if (queue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(queue.peek());

            } else if (str[0].equals("back")) {
                if (queue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(back);
            }

        }
    }
}