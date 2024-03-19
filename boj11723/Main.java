package boj11723;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int [] arr = new int[21];   // 0번 인덱스 사용X

        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            if(method.equals("add")){
                arr[Integer.parseInt(st.nextToken())] = 1;
            }else if(method.equals("remove")){
                arr[Integer.parseInt(st.nextToken())] = 0;
            }else if(method.equals("check")){
                bw.write(String.valueOf(arr[Integer.parseInt(st.nextToken())]));
                bw.newLine();
            }else if(method.equals("toggle")){
                int i = Integer.parseInt(st.nextToken());
                if(arr[i] == 1){
                    arr[i] = 0;
                }else{
                    arr[i] = 1;
                }
            }else if(method.equals("all")){
                for(int i = 1; i < arr.length; i++){
                    arr[i] = 1;
                }
            }else if(method.equals("empty")){
                for(int i = 1; i < arr.length; i++){
                    arr[i] = 0;
                }
            }
        }
        bw.flush();
    }
}
