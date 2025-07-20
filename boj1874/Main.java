package boj1874;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>();

		st.push(1);
		sb.append("+\n");
		int count = 2;

		while (n-- > 0) {
			int k = Integer.parseInt(br.readLine());

			// 수열 생성 불가
			if (!st.isEmpty() && st.peek() > k) {
				System.out.println("NO");
				return;
			}

			// peek와 다를경우 먼저 push
			if (st.isEmpty() || !st.peek().equals(k)) {
				while (count <= k) {
					st.push(count);
					sb.append("+\n");
					count++;
				}
			}

			// stack 맨위에 있는 경우
			if (st.peek().equals(k)) {
				st.pop();
				sb.append("-\n");
			}
		}

		System.out.println(sb);

	}

}

// private void firstTry() throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringBuilder sb = new StringBuilder();
//
//     Stack<Integer> stack = new Stack<>();
//
//     int n = Integer.parseInt(br.readLine());
//
//     int top = 0;
//
//     for (int i = 0; i < n; i++) {
//         int num = Integer.parseInt(br.readLine());
//
//         if (num > top) {
//             for (int j = top+ 1; j <= num; j++) {
//                 stack.push(j);
//                 sb.append("+").append("\n");
//             }
//             top = num;
//         } else {
//             if (stack.peek() != num) {
//                 System.out.println("No");
//                 return;
//             }
//         }
//         stack.pop();
//         sb.append("-").append("\n");
//     }
//     System.out.println(sb);
// }