package boj1541;
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String formula = br.readLine();

		LinkedList<Integer> nums = new LinkedList<>();
		LinkedList<Character> marks = new LinkedList<>();

		// 초기화
		int start = 0;
		boolean plusFlag = true;
		for(int i = 0; i < formula.length(); i++){
			// 문자
			if(formula.charAt(i) == '+' || formula.charAt(i) == '-'){
				int num = Integer.parseInt(formula.substring(start, i));
				nums.add(num);

				marks.add(formula.charAt(i));

				start = i+1;

				if(formula.charAt(i) == '-') plusFlag = false;
			}
			// 마지막 숫자
			else if(i == formula.length() - 1){
				int num = Integer.parseInt(formula.substring(start, i+1));
				nums.add(num);
			}
		}


		// 더하기 먼저
		for(int i = 0; i < marks.size(); i++){
			if(marks.get(i) == '+'){
				nums.add(i, nums.get(i) + nums.get(i+1));
				nums.remove(i+1);
				nums.remove(i+1);
				marks.remove(i);
				i--;
			}
		}

		int res = nums.get(0);
		for(int i = 0; i < marks.size(); i++){
			res -= nums.get(i+1);
		}

		System.out.println(res);
	}
}