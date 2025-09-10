package boj11286;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Num> pQ = new PriorityQueue<>();

		while(n --> 0){
			int m = Integer.parseInt(br.readLine());

			if(m == 0){
				if(pQ.isEmpty()){	// 비어있는 경우에는 0 출력
					bw.write(0+"\n");
				}else{
					int k = pQ.poll().getNum();
					bw.write(k+"\n");
				}
			}else{
				pQ.offer(new Num(m, Math.abs(m)));
			}
		}

		bw.flush();
	}
}

// 절댓값도 포함한 클래스 Num
class Num implements Comparable<Num>{
	int num;
	int abs;

	public Num(int num, int abs){
		this.num = num;
		this.abs = abs;
	}

	public int getNum(){
		return this.num;
	}

	@Override
	public int compareTo(Num o){
		if(this.abs > o.abs){	// 새로 들어오는 값(this)의 절대값이 크면 낮은 우선순위
			return 1;
		}else if(this.abs == o.abs){
			if(this.num > o.num){	// 절대값이 같은 경우, 실제값이 크면 낮은 우선순위
				return 1;
			}else if(this.num == o.num){
				return 0;
			}else{
				return -1;
			}
		}else{
			return -1;
		}
	}
}
