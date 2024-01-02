package boj10814;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Member> arrayList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        // 회원 입력
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            Member member = new Member(age, st.nextToken());
            arrayList.add(member);
        }

        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).age+" "+arrayList.get(i).name);
        }

    }
}

class Member implements Comparable<Member>{
    int age;
    String name;

    Member(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        return this.age - o.age;
    }
}