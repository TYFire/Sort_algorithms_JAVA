import java.util.Random;
public class LargestK{
	public static void main(String [] args){
		int [] input = new int[10000];
		Random r = new Random();
		for(int i = 0; i < 10000; i++){
			input[i] = r.nextInt(3000);
		}
		printArray(input);
		int[] ret = largestK2(input, 100);
		printArray(ret);
		System.out.println(check(ret, input));
	}



	public static int[] largestK(int[] input, int k){
		int [] ret = new int[k];
		for(int i = 0; i < k; i++){
			ret[i] = input[i];
		}
		for(int i = ret.length/2+1; i >= 0; i--){
			heapAdjustDown(ret, i, ret.length);
		}
		for(int i = k; i <input.length; i++){
			if(input[i] > ret[0]){
				ret[0] = input[i];
				heapAdjustDown(ret, 0, ret.length);
			}
		}
		return ret;
	}

	public static int[] largestK2(int input[], int k){
		int [] ret = new int[k];
		int size = 0;
		for(int i = 0; i <input.length; i++){
			if(size < k){
				heapAdjustUp(ret, size, input[i]);
				size++;
			}else if(input[i] > ret[0]){
				ret[0] = input[i];
				heapAdjustDown(ret, 0, ret.length);
			}
		}
		return ret;
	}

	public static void heapAdjustUp(int [] input, int i, int val){
		if(i == 0){
			input[i] = val;
			return;
		}
		int parent = parent(i);
		if(input[parent] > val){
			input[i] = input[parent];
			heapAdjustUp(input, parent, val);
		}else{
			input[i] = val;
		}
	}

	public static int parent(int i){
		return (i-1)/2;
	}

	public static int left(int i){
		return i*2 + 1;
	}

	public static int right(int i){
		return i*2 + 2;
	}

	public static void heapAdjustDown(int [] input, int i, int size){
		int left = left(i), right = right(i), smallest = -1;
		if(left < size && input[left] < input[i]){
			smallest = left;
		}else{
			smallest = i;
		}
		if(right < size && input[smallest] > input[right]){
			smallest = right;
		}
		if(smallest == i){
			return ;
		}
		int tmp = input[i];
		input[i] = input[smallest];
		input[smallest] = tmp;
		heapAdjustDown(input, smallest, size);
	}

	public static void printArray(int [] input){
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < input.length; i++){
			ret.append(input[i] + " ");
		}
		System.out.println(ret.toString());
	}

	public static boolean check(int [] ret, int input[]){
		new Quick_sort().sort(ret, 0, ret.length-1);
		new Quick_sort().sort(input, 0, input.length -1);
		for(int i = ret.length-1; i >=0; i--){
			if(ret[i] != input[10000 - 100 + i]){
				return false;
			}
		}
		return true;
	}

}
