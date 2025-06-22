package boj10824;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        String C = st.nextToken();
        String D = st.nextToken();

        String strX = A.concat(B);
        String strY = C.concat(D);

        Long longX = Long.valueOf(strX);
        Long longY = Long.valueOf(strY);

        System.out.println(longX + longY);

    }
}
