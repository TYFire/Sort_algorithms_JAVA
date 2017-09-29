public class Merge_sort{
	public void sort(int input[], int start, int end){
		if(start < end){
			int mid = (start + end) / 2;
			sort(input, start, mid);
			sort(input, mid+1, end);
			merge(input, start, mid, end);
		}
	}

	public void merge(int input[], int start, int mid, int end){
		int tmp[] = new int[end-start+1];
		int i = start, j = mid+1, k = 0;
		while(i <= mid || j <= end){
			if(i <= mid && j <= end){
				if(input[i] < input[j]){
					tmp[k++] = input[i++];
				}else{
					tmp[k++] = input[j++];
				}
			}else if(i <= mid && j > end){
				tmp[k++] = input[i++];
			}else if(i > mid && j <= end){
				tmp[k++] = input[j++];
			}
		}
		for(int l = 0; l < tmp.length; l++){
			input[start+l] = tmp[l];
		}
	}

	public void swap(int input[], int i, int j){
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
