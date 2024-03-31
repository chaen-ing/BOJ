package boj1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        while(N --> 0){
            hashSet.add(br.readLine());
        }

        ArrayList<String> arrayList = new ArrayList<>();
        int cnt = 0;

        while(M --> 0){
            String str = br.readLine();
            if(hashSet.contains(str)){
                arrayList.add(str);
                cnt++;
            }
        }

        Collections.sort(arrayList);

        System.out.println(cnt);
        for(String i : arrayList){
            System.out.println(i);
        }

    }
}
