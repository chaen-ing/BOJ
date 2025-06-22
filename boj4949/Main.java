package boj4949;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		Stack<Character> smallStack;
		Stack<Character> bigStack;

		while (true) {
			st = new StringTokenizer(br.readLine());	//한줄 read
			if(st.nextToken().equals(".")) break;	//.이면 종료

			Boolean flag = true;

			smallStack = new Stack<>();
			bigStack = new Stack<>();

			while (st.hasMoreTokens()) {
				String token = st.nextToken();

				if(token.equals("(")){
					smallStack.push('(');
				}else if(token.equals(")")){
					if (smallStack.isEmpty()) {
						flag=false;
						break;
					}else{
						smallStack.pop();
					}
				}else if(token.equals("[")){
					bigStack.push('[');
				}else if(token.equals("]")){
					if(bigStack.isEmpty()){
						flag=false;
						break;
					}else{
						bigStack.pop();
					}
				}
			}

			if (flag = false) {
				bw.write("no");
			} else if(smallStack.isEmpty() && bigStack.isEmpty()){
				bw.write("yes");
			}else{
				bw.write("no");
			}

			bw.newLine();
		}


		bw.flush();

	}
}
