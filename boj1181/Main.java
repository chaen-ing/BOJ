package boj1181;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List <String> str = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            str.add(br.readLine());
        }

        Collections.sort(str, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() == o2.length()) // 문자열 길이 같은경우
                            return o1.compareTo(o2);
                        return o1.length() - o2.length();
                    }
                });

        System.out.println(str.get(0));
        for(int i = 1; i < N; i++){
            if(!str.get(i).equals(str.get(i-1))){
                System.out.println(str.get(i));
            }
        }
    }
}
