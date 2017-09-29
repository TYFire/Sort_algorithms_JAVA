//import Insert_sort;
//assume int array 
import java.util.Random;
public class Sort_main{
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
		//new Bubble_sort().sort(input);
		//new Quick_sort().sort(input, 0, input.length-1);
		//new Heap_sort().sort(input, input.length);
		new Quick_sort().sort2(input, 0, input.length-1);

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
		for(int i = 1; i < input.length; i++){
			if(input[i-1] > input[i]){
				return false;
			}
		}
		return true;
	}
}
