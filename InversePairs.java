import java.util.Random;

public class InversePairs{
	public static void main(String args[]){
		Random r = new Random();
		int len = r.nextInt(1000);
		int [] input = new int[len];
		for(int i = 0; i < len; i++){
			input[i] = r.nextInt(3000);
		}
		printArray(input);
		int tmp = 0;
		for(int i = 0; i < input.length; i++){
			for(int j = i; j < input.length; j++){
				if(input[i] > input[j]){
					tmp++;
				}
			}
		}
		int ret = sort(input, 0, input.length-1);
		System.out.println("sort_res = "+ ret + ", " + "real_res = " + tmp + ", " + (ret==tmp));

	}

	public static int sort(int input[], int start, int end){
		int ret = 0;
		if(start < end){
			int mid = (start + end) / 2;
			ret += sort(input, start, mid);
			ret += sort(input, mid+1, end);
			ret += merge(input, start, mid, end);
		}
		return ret;
	}

	public static int merge(int input[], int start, int mid, int end){
		int tmp[] = new int[end-start+1];
		int i = mid, j = end, k = tmp.length-1;
		int ret = 0;
		while(i >= start || j >= mid+1){
			if(i >= start && j >= mid+1){
				if(input[i] <= input[j]){
					tmp[k--] = input[j--];
				}else{
					ret += j-mid;
					tmp[k--] = input[i--];
				}
			}else if(i >= start && j < mid+1){
				tmp[k--] = input[i--];
			}else if(i < start && j >= mid+1){
				tmp[k--] = input[j--];
			}
		}
		for(int l = 0; l < tmp.length; l++){
			input[start+l] = tmp[l];
		}
		return ret;
	}

	public static void printArray(int [] input){
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < input.length; i++){
			ret.append(input[i] + " ");
		}
		System.out.println(ret.toString());
	}

	public void swap(int input[], int i, int j){
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
