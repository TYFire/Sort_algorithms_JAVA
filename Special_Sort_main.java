
//assume int array 

import java.util.Random;
public class Special_Sort_main{
	public static void main(String[] args){
		Random r = new Random();
		int len = r.nextInt(1000);
		int [] input = new int[len];
		for(int i = 0; i < len; i++){
			input[i] = r.nextInt(3000);
		}
		//int [] input = {2,16,8,32,12,1,6,7,7,6,2};
		printArray(input);
		System.out.println(check(input));

		//new Insert_sort().sort(input);
		//new Binary_sort().sort(input);
		//new Selection_sort().sort(input);
		sort2(input);

		printArray(input);
		System.out.println(check(input));
	}
	
	public static void printArray(int [] input){
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < input.length; i++){
			ret.append(input[i] + " ");
		}
		System.out.println(ret.toString());
	}

	public static boolean check(int input[]){
		if(input.length == 0 || input.length == 1){
			return true;
		}
		int smaller = sum(input);
		for(int i = 0; i < smaller; i++){
			if(!isSmaller(input[i])){
				return false;
			}
		}
		for(int i  = smaller; i < input.length; i++){
			if(isSmaller(input[i])){
				return false;
			}
		}
		return true;
	}

	public static int sum(int input[]){
		int ret = 0;
		for(int i = 0; i < input.length; i++){
			if(isSmaller(input[i])){
				ret++;
			}
		}
		return ret;
	}

	//assume 1500
	public static boolean isSmaller(int i){
		return i < 1500;
	}

	public static void sort(int input[]){
		for(int i = input.length-1; i >= 0; i--){
			if(!isSmaller(input[i])){
				for(int j = i+1; j < input.length; j++){
					if(isSmaller(input[j])){
						int tmp = input[j-1];
						input[j-1] = input[j];
						input[j] = tmp;
					}else{
						break;
					}
				}
			}
		}
	}

	public static void sort2(int input[]){
		int i = 0, j = input.length -1, tmp = input[0];
		do{
			while(!isSmaller(input[j]) && i < j){
				j--;
			}
			if(i < j){
				input[i] = input[j];
				i++;
			}
			while(isSmaller(input[i]) && i < j){
				i++;
			}
			if(i < j){
				input[j] = input[i];
				j--;
			}
		}while(i!=j);
		input[i] = tmp;

	}

}
