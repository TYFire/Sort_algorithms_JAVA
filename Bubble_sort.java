public class Bubble_sort{
	public void sort(int input[]){
		for(int i = input.length-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(input[j] > input[j+1]){
					int tmp = input[j];
					input[j] = input[j+1];
					input[j+1] = tmp;
				}
			}
		}
	}
}
