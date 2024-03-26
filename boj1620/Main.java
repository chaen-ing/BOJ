package boj1620;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, String> hashMapInt = new HashMap<>();
        HashMap<String, Integer> hashMapStr = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <=N; i++){
            String str = br.readLine();
            hashMapInt.put(i,str);
            hashMapStr.put(str,i);
        }

        while(M-->0){
            String str = br.readLine();
            if(str.charAt(0) >= '1' && str.charAt(0) <= '9'){
                bw.write(hashMapInt.get(Integer.parseInt(str)));
                bw.newLine();
            }else{
                bw.write(hashMapStr.get(str)+"");
                bw.newLine();
            }
        }

        bw.flush();

    }
}
