package boj1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < N; i++){
			queue.offer(Integer.parseInt(br.readLine()));
		}

		int tmp1 = 0;
		int tmp2 = 0;
		int sum = 0;
		while(queue.size() != 1){
			tmp1 = queue.poll();
			tmp2 = queue.poll();
			sum += tmp1 + tmp2;
			queue.offer(tmp1 + tmp2);
		}

		System.out.println(sum);

	}
}
