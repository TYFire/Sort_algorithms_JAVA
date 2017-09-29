public class Selection_sort{
	public void sort(int input[]){
		
		for(int i = 0; i < input.length; i++){
			int p = i;
			for(int j = i+1; j < input.length; j++){
				if(input[j] < input[p]){
					p = j;
				}
			}
			int tmp = input[p];
			input[p] = input[i];
			input[i] = tmp;
		}
	}

}
