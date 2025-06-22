package boj1406;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // stack 2개 활용
        Stack<Character> ls = new Stack<>();
        Stack<Character> rs = new Stack<>();

        // 초기 문자열
        char[] initialArr = br.readLine().toCharArray();

        // 초기 문자열 ls에 저장
        for (char c : initialArr) {
            ls.push(c);
        }

        int n = Integer.parseInt(br.readLine());  // 명령 개수

        while(n-->0){
            st = new StringTokenizer(br.readLine());

            char command = st.nextToken().charAt(0);

            switch (command){
                // L : 커서를 왼쪽으로 한칸 옮김. 맨앞이면 무시
                // ls의 top에 있는 값 -> rs
                case 'L':
                    if(!ls.isEmpty())
                        rs.push(ls.pop());
                    break;

                // L : 커서를 오른쪽으로 한칸 옮김. 맨뒤이면 무시
                // rs의 top에 있는 값 -> ls
                case 'D':
                    if(!rs.isEmpty())
                        ls.push(rs.pop());
                    break;

                // B : 커서 왼쪽 문자 삭제
                // ls의 top 삭제
                case 'B':
                    if(!ls.isEmpty())
                        ls.pop();
                    break;

                // P : 문자를 커서 왼쪽에 추가
                // ls의 top에 문자 넣기
                case 'P':
                    char alp = st.nextToken().charAt(0);
                    ls.push(alp);
                    break;
            }
        }

        // rl -> rs로 다 옮기고 출력하기
        while(!ls.isEmpty()){
            rs.push(ls.pop());
        }

        while(!rs.isEmpty()){
            sb.append(rs.pop());
        }

        System.out.println(sb);
    }
}
