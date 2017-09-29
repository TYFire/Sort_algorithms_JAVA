public class Quick_sort {
	public static void sort(int input[], int left, int right){
		if(left < right){
			int i = left, j = right, tmp = input[i];
			do
			{
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
			sort(input, left, i-1);
			sort(input, i+1, right);
		}
	
	}

	public static void sort2(int[] input, int left, int right){
		if(left < right){
			int mid = onePass(input, left, right);
			sort2(input, left, mid-1);
			sort2(input, mid+1, right);
		}
	}

	public static int onePass(int [] input, int left, int right){
		int i = left, j = right;
		int tmp = input[left];
		while(i < j){
			while(i < j && input[j] >= tmp){
				j--;
			}
			if(i < j){
				input[i++] = input[j];
			}

			while(i < j && input[i] <= tmp){
				i++;
			}
			if(i < j){
				input[j--] = input[i];
			}
		}
		input[i] = tmp;
		return i;
	}


}
