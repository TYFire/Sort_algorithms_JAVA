public class Heap_sort{
	

	public void sort(int input[], int size){
		heapBuild(input, size);
		for(int i = size; i >= 1; i--){
			heapAdjust(input, 0, i);
			int tmp = input[i-1];
			input[i-1] = input[0];
			input[0] = tmp;
			
		}
	
	}

	public static int left(int i){
		return i*2 + 1;
	}

	public static int right(int i){
		return i*2 + 2;
	}

	public static void heapAdjust(int input[], int i, int size){
		int left = left(i), right = right(i), largest = -1;
		if(left < size && input[i] < input[left]){
			largest = left;
		}else{
			largest = i;
		}
		if(right < size && input[largest] < input[right]){
			largest = right;
		}
		if(largest == i){
			return;
		}
		int tmp = input[largest];
		input[largest] = input[i];
		input[i] = tmp;
		heapAdjust(input, largest, size);

	}

	public static void heapBuild(int[] input, int size){
		for(int i = size/2+1; i >= 0; i--){
			heapAdjust(input, i, size);
		}
	}

}
