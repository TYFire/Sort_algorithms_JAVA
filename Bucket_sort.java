import java.util.Random;
import java.util.*;
public class Bucket_sort{
	public static void main(String args[]){
		Random r = new Random();
		int len = r.nextInt(5000000);
		int [] input = new int[len];
		for(int i = 0; i < len; i++){
			input[i] = r.nextInt(801)+100;
		}
		printArray(input);

		//bucketSort(input,100);
		bucketSort2(input, 100, 900, 1);

		printArray(input);
		System.out.println(check(input));

	}

	public static void bucketSort(int input[], int range){
		int tmp[][] = new int[range/10][input.length];
		int count[] = new int[range/10]; 
		for(int i = 0; i < input.length; i++){
			int val = input[i]/10;
			tmp[val][count[val]] = input[i];
			count[val]++;
		}
		
		int k = 0;
		for(int i = 0; i < tmp.length; i++){
			new Quick_sort().sort(tmp[i], 0, count[i]-1);
			for(int j = 0; j < count[i]; j++){
				input[k++] = tmp[i][j];
			}
		}


	}

	public static void bucketSort2(int input[], int min, int max, int step){
		List<List<Integer>> tmp = new ArrayList<>();
		int num = (max - min) / step;
		if(num < 1){
			num++;
		}
		for(int i = 0; i <= num; i++){
			List<Integer> bucket = new ArrayList<>();
			tmp.add(bucket);
		}
		for(int i = 0; i < input.length; i++){
			int val = (input[i]-min)/step;
			tmp.get(val).add(input[i]);
		}
		
		int k = 0;
		for(int i = 0; i < tmp.size(); i++){
			//new Bubble_sort().sort(tmp.get(i));// for this specific case, dont have to sort anymore
			for(int j = 0; j < tmp.get(i).size(); j++){
				input[k++] = tmp.get(i).get(j);
			}
		}


	}

	public static void printArray(int [] input){
		System.out.println(input.length);
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
