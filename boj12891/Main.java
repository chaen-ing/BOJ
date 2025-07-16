package boj12891;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());	// 문자열 길이
		int p = Integer.parseInt(st.nextToken());	// 비밀번호 길이

		String str = br.readLine();	// 문자열

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int count = 0;
		int start = 0;
		int end = p-1;
		int [] acgt = new int [100];

		// 첫번째
		String temp = str.substring(start, p);
		for(int i = 0; i < p; i++){
			char chr = temp.charAt(i);
			if(chr == 'A'){
				acgt['A' - '0']++;
			}else if(chr == 'C'){
				acgt['C' - '0']++;
			}else if(chr == 'G'){
				acgt['G' - '0']++;
			}else{
				acgt['T' - '0']++;
			}
		}
		if(acgt['A' - '0'] >= a && acgt['C' - '0'] >= c && acgt['G' - '0'] >= g && acgt['T' - '0'] >= t){
			count++;
		}

		while(end < s - 1){
			start++;
			end++;

			acgt[str.charAt(start-1) - '0']--;
			acgt[str.charAt(end) - '0']++;

			if(acgt['A' - '0'] >= a && acgt['C' - '0'] >= c && acgt['G' - '0'] >= g && acgt['T' - '0'] >= t){
				count++;
			}
		}
		System.out.println(count);
	}
}
