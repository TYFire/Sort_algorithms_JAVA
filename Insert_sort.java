public class Insert_sort{
	public void sort(int [] input){
		if(input.length == 0){
			return;
		}
		boolean flag = false;
		for(int i = 1; i < input.length; i++){
			flag = false;
			for(int j = i-1; j >= 0; j--){
				if(input[i] > input[j]){
					move(input, i, j);
					flag = true;
					break;	
				}
			}
			if(flag == false){
				move(input, i, -1);
			}
		}
	}

	public void move(int[] input, int i, int j){
		int tmp = input[i];
		for(int k = i-1; k > j; k--){
			input[k+1] = input[k];
		}
		input[j+1] = tmp;
	}

}
