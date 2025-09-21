package boj1377;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기화
		int n = Integer.parseInt(br.readLine());
		mData [] arr = new mData[n];
		for(int i = 0; i < n; i++){
			int m = Integer.parseInt(br.readLine());
			arr[i] = new mData(m, i);
		}

		// 정렬
		Arrays.sort(arr);

		int max = 0;
		for(int i = 0; i < n; i++){
			int m = arr[i].index - i;
			if(max < m){
				max = m;
			}
		}

		System.out.println(max + 1);

	}
}

class mData implements Comparable<mData>{

	int value;
	int index;

	public mData(int value, int index){
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(mData o){
		return this.value - o.value;
	}
}
