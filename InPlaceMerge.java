import java.util.Random;

public class InPlaceMerge{
	public static void main(String args[]){
		Random r = new Random();
		int len = r.nextInt(1000);
		//int len = 10;
		int [] input = new int[len];
		for(int i = 0; i < len; i++){
			input[i] = r.nextInt(3000);
		}
		int mid = len/2;
		new Quick_sort().sort(input, 0, mid);
		new Quick_sort().sort(input, mid+1, len-1);
		printArray(input);
		
		int [] tmp = new int[len];
		for(int i = 0; i < len; i++){
			tmp[i] = input[i];
		}
		new Quick_sort().sort(tmp, 0, tmp.length-1);
		
		inPlaceMerge(input, 0, mid, len-1);
		printArray(input);
		System.out.println(check(input, tmp));
	}


	public static void printArray(int [] input){
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < input.length; i++){
			ret.append(input[i] + " ");
		}
		System.out.println(ret.toString());
	}

	public static boolean check(int[] input, int[] tmp){
		for(int i = 0; i < input.length; i++){
			if(input[i] != tmp[i]){
				return false;
			}
		}
		return true;
	}

	public static void inPlaceMerge(int input[], int start, int mid, int end){
		// start, mid; mid+1, end
		int i = start, j = mid+1, split = mid;
		while(i <= split && j <= end){
			while(i <= split && input[i] <= input[j]){
				i++;
			}
			while(j <= end && input[j] <= input[i]){
				j++;
			}
			exchange(input, i, split, j-1);
			int tmp = j-split-1;
			i += tmp;
			split += tmp;

		}
	}

	public static void exchange(int input[], int start, int mid, int end){
		reverse(input, start, mid);
		reverse(input, mid+1, end);
		reverse(input, start, end);
	}

	public static void reverse(int input[], int i, int j){
		for(int k = i; k <= (j+i)/2; k++){
			swap(input, k, j-(k-i));
		}
	}

	public static void swap(int input[], int i, int j){
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
