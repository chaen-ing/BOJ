package boj2750;
import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 초기화
		int [] arr = new int [n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}


		// 버블정렬
		int temp;
		for(int i = n - 1; i > 0; i--){
			for(int j = 0; j < i; j++){

				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}

			}
		}

		// 출력
		for(int i = 0; i < n; i++){
			System.out.println(arr[i]);
		}

	}

	private static void first() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N];

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for(int i = 0; i < N; i++){
			bw.write(arr[i] + "\n");
		}

		bw.flush();
		bw.close();
	}
}
