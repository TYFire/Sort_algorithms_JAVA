
import java.util.Random;
public class SmallerK {
	public static void main(String [] args){
		Random r = new Random();
		int len = r.nextInt(1000);
		int [] input = new int[len];
		for(int i = 0; i < len; i++){
			input[i] = r.nextInt(3000);
		}
		printArray(input);
		
		int [] tmp = new int[len];
		for(int i = 0; i < len; i++){
			tmp[i] = input[i];
		}

		int k = r.nextInt(len);
		System.out.println("k = " + k);
		int [] ret = smallerK(input, k);
		printArray(ret);

		System.out.println(check(tmp,ret));
	}

	public static void printArray(int [] input){
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < input.length; i++){
			ret.append(input[i] + " ");
		}
		System.out.println(ret.toString());
	}

	public static boolean check(int[] tmp, int[] ret){
		new Quick_sort().sort(tmp, 0, tmp.length-1);
		new Quick_sort().sort(ret, 0, ret.length-1);
		for(int i = 0; i < ret.length; i++){
			if(ret[i]!=tmp[i]){
				return false;
			}
		}
		return true;
	}

	public static int [] smallerK(int[] input, int k){
		helper(input, k, 0, input.length-1);
		int []ret = new int[k];
		for(int m = 0; m < k; m++){
			ret[m] = input[m];
		}
		return ret;
	}

	public static void helper(int []input, int k, int left, int right){
		if(left < right){
			int i = left, j = right, tmp = input[left];
			do{
				while(input[j] > tmp && i < j){
					j--;
				}
				if(i < j){
					input[i] = input[j];
					i++;
				}
				while(input[i] < tmp && i < j){
					i++;
				}
				if(i < j){
					input[j] = input[i];
					j--;
				}
			}while(i!=j);
			input[i] = tmp;
			if(i+1 < k){
				helper(input, k, i+1, right);
			}else if(i+1 >k){
				helper(input, k, left, i-1);
			}else{				
				return;
			}
		}
	}
}
