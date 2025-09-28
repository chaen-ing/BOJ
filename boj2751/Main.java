package boj2751;

import java.io.*;

public class Main {
	static int [] arr;
	static int [] sorted;

	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기화
		int n = Integer.parseInt(br.readLine());
		arr = new int [n];
		sorted = new int [n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(n);

		for(int i = 0; i < n; i++){
			System.out.println(arr[i]);
		}

	}

	public static void mergeSort(int length){
		mergeSort(0, length - 1);
		sorted = null;	// 임시배열이라는 것 명시적으로 의미
	}

	// Bottom up 구현
	private static void mergeSort(int left, int right){

		// 1 - 2 - 4 - 8 ... 식으로 서브리스트 나누는 기준 2배씩 늘림
		for(int size = 1; size <= right; size += size){

			/**
			 * 두 부분 리스트를 순서대로 병합
			 * ex) 현재 부분 리스트 크기가 1일때
			 * 왼쪽 부분리스트(low - mid)와 오른쪽 부분리스트(mid +1 - high)를 생각하면
			 * 왼쪽 부분리스트는 low = mid = 0이고,
			 * 오른족 부분리스트는 mid + 1 부터 low + (2 * size) - 1 = 1
			 * 이때 high가 배열의 인덱스 넘어갈 수 있으므로 right, high 중 작은값 선택
			 */
			for(int l = 0; l <= right - size; l += (2*size)){
				int low = l;
				int mid = l + size - 1;
				int high = Math.min(l + (2*size) - 1, right);
				merge(low, mid, high);
			}
		}
	}

	// 합칠 부분 리스트는 원 배열의 left-right
	private static void merge(int left, int mid, int right){
		int l = left;	// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트 시작점
		int idx = left;	// 채워넣을 배열 인덱스

		while(l <= mid && r <= right){
			// 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째보다 작거나 같을때
			// 왼쪽의 l번째를 새 배열에 넣고 l과 idx를 1 증가
			if(arr[l] <= arr[r]){
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
			// 오른쪽 부분리스트의 r번째 원소가 왼쪽 l번쨰보다 작거나 같을때
			// 오른쪽 r번째 원소를 새 배열에 넣고 r과 idx를 1증가
			else{
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		}

		// 왼쪽 부분리스트가 먼저 모두 새 배열에 채워진 경우 (l > mid)
		// 오른쪽 부분리스트들을 채워줌
		if(l > mid){
			while(r <= right){
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		}

		// 반대의 경우...
		else{
			while(l <= mid){
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
		}

		for(int i = left; i <= right; i++){
			arr[i] = sorted[i];
		}
	}
}
