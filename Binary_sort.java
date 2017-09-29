public class Binary_sort{
	public void sort(int [] input){
		if(input.length == 0){
			return;
		}
		boolean flag = false;
		for(int i = 1; i < input.length; i++){
			int start = 0, end = i-1;
			while(start <= end){
				int mid = (start + end)/2;
				if(input[mid] == input[i]){
					//move(input, i, j);
					start = mid;
					break;
				}else if(input[mid] > input[i]){
					end = mid-1;
				}else if(input[mid] < input[i]){
					start = mid+1;
				}
			}
			move(input, i, start-1);
		}
	}
	// i is the one we are working on, we will work on ones after j, right stop at i
	public void move(int[] input, int i, int j){
		int tmp = input[i];
		for(int k = i-1; k > j; k--){
			input[k+1] = input[k];
		}
		input[j+1] = tmp;
	}


}
