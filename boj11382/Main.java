package boj11382;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //최대 1,000,000,000,000

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        BigInteger C = new BigInteger(st.nextToken());

        BigInteger sum = A.add(B).add(C);
        System.out.println(sum);

    }
}
