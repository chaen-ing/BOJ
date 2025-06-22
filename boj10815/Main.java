package boj10815;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 갖고 있는 카드 개수

        int [] nArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < n; k++){ // 배열에 갖고 있는 숫자 저장
            nArr[k] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);  // 오름차순 정렬

        int m = Integer.parseInt(br.readLine());    // 찾아야하는 숫자 개수

        st = new StringTokenizer(br.readLine());

        boolean exist = false;
        for(int i = 0; i < m; i++){
            int checkNum = Integer.parseInt(st.nextToken());

            int lo = 0;
            int hi = n-1;

            while(lo <= hi){
                int mid = lo + ((hi-lo)/2);

                if(nArr[mid] < checkNum)
                    lo = mid + 1;
                else if(nArr[mid] > checkNum)
                    hi = mid - 1;
                else{
                    exist = true;
                    break;
                }
            }

            if(exist == true){
                sb.append("1 ");
            }

            else{
                sb.append("0 ");
            }

            exist = false;
        }
        System.out.println(sb);


    }
}