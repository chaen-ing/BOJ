package boj1316;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 단어 갯수

        int groupNumCnt = 0;

        while(n-->0){
            String str = br.readLine();
            boolean [] visited = new boolean[26];   // 알파벳 갯수
            boolean groupNum = true;

            char ch = str.charAt(0);
            visited[ch-97] = true;


            for(int i = 1; i < str.length(); i++){
                // 길이가 1일 경우
                if(str.length() == 1)
                    break;
                // 다음 알파벳이 같을때
                if(ch == str.charAt(i))
                    continue;
                // 다음 알파벳이 다를 때
                else{
                    if(visited[str.charAt(i) - 97]){    // 다음 알파벳이 나온적 있는 알파벳일때
                        groupNum = false;
                        break;
                    }
                    ch = str.charAt(i);
                    visited[ch-97] = true;
                }
            }

            if(groupNum)
                groupNumCnt++;

        }

        System.out.println(groupNumCnt);

    }
}
