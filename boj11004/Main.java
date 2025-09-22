package boj11004;

import java.io.*;
import java.util.*;

public class Main {
	static int [] arr;

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(0, n-1);

		System.out.println(arr[k-1]);

	}

	static void quickSort(int start, int end){
		// start가 end보다 크거나 같다면 정렬할 원소가 1개 이하이므로 정렬하지 않고 리턴
		if (start >= end){
			return;
		}

		// partition으로 좌,우 영역 분할
		int pivot = partition(start, end);

		// 각 영역 정렬
		quickSort(start, pivot);
		quickSort(pivot+1, end);
	}

	// 예를 들어 pivot이 4라고 치면 4 왼쪽은 다 작은 수, 오른쪽은 다 큰수로 만드는 것
	static int partition(int left, int right){
		// 각각 배열의 끝에서 1 벗어난 위치부터 시작 (구간 밖에서부터)
		int start = left - 1;
		int end = right + 1;
		int pivot = arr[(left+right) / 2];	// 중간을 피봇설정


		while(true){
			// 왼쪽에서 pivot보다 큰 값이 나올 떄 까지 이동
			do{
				start++;
			}while(arr[start] < pivot);

			// 오른쪽에서 pivot보다 작은 값이 나올 때 까지 이동 or start랑 end랑 만날때까지 이동
			do{
				end--;
			}while(arr[end] > pivot && start <= end);

			// 포인터가 만나는 순간이 오면 종료하고 pivot을 리턴
			if(start >= end) {
				return end;
			}

			swap(start, end);
		}
	}

	static void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
