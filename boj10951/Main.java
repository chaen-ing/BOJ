package boj10951;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        while(str != null){ // BufferedReader는 입력이 없을시 Null을 반환
            st = new StringTokenizer(str);
            System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
            str = br.readLine();
        }
    }
}
