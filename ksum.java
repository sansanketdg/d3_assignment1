package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp = {1, 0, -1, 0, -2, 2, 3};
		int k = 4;
		int target = 0;
		List<List<Integer>> out = kSum(inp, k, target);
		for(int i = 0; i < out.size(); i++){
			System.out.println(out.get(i));
		}
		
	}

	private static List<List<Integer>> kSum(int[] inp, int k, int target) {
		// TODO Auto-generated method stub
		Arrays.sort(inp);
		return kSumHelper(inp, k, target, 0);
	}

	private static List<List<Integer>> kSumHelper(int[] inp, int k, int target, int p) {
		// TODO Auto-generated method stub
		List<List<Integer>> out =  new ArrayList<List<Integer>>();
		if(k == 2){
			int i = p, j = inp.length - 1;
			while(i < j){
				if(i > p && inp[i] == inp[i-1]){
					i++;
					continue;
				}
				int sum = inp[i] + inp[j];
				if(sum == target) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(inp[i++]);
					tmp.add(inp[j--]);
					out.add(tmp);
				}
				else if(sum > target)
					j--;
				else
					i++;
					
			}
		}
		//if k > 2
		else {
			for(int i = p; i < inp.length; i++){
				List<List<Integer>>k_1_Sum = kSumHelper(inp, k-1, target - inp[i], i+1);
				for(List<Integer> each : k_1_Sum){
					List<Integer> newL = new ArrayList<>(each);
					newL.add(inp[i]);
					out.add(newL);
				}
			}
		}
		return out;
	}

}

