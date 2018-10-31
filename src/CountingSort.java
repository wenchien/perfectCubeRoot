import java.util.Arrays;

public class CountingSort {
	static char[] array = new char[] {'1', '4', '1', '2', '7', '5', '2'};
	static int[] temp = new int[256];
	static char[] output = new char[array.length];
	//Driver function
	public static void main (String[] args) {
		countingSort(array);
		//Complexity: O(n+k) n = # of input, k = rangeMax - rangeMini
		//More memory usage
		//Use only if input sequence is known
		//if unknown, use something else, other sorts that are O(nlogn)
	}
	
	static void countingSort(char[] array) {
		//temp array = count array
		for (int i=0; i < 256; ++i) {
			temp[i] = 0;
		}
            
		for (int i = 0; i < array.length; ++i) {
			//++temp[array[i]];
			//array[i] = key
			//++increment the amount of same key by 1 each time a duplicate is there.
			System.out.println(++temp[array[i]]);
		}
		
		for (int i = 1; i < temp.length - 1; ++i) {
			temp[i] += temp[i - 1]; //Modify the count array such that each element at each index 
			  						//stores the sum of previous counts. 
									//if at for example index 2, add count of index 0, 1 and 2 and the final values is the value that will be stored
									//in count['2']
									//The modified count array indicates the position of each object in 
									//the output sequence.
		}
		/*
		 * Index:     0  1  2  3  4  5  6  7  8  9
  			Count:     0  2  4  4  5  6  6  7  7  7
		 */
		for (int i = 0; i < array.length; ++i) {
			//Take the position of a particular number, say position 0, and store it in position count - 1 and decrease the count for that data by 1
			//'1', '4', '1', '2', '7', '5', '2'
			//'1', '1', '2', '2', '4', '5', '7'
			output[temp[array[i]] - 1] = array[i];
            --temp[array[i]];
		}
		
		//Similar to the idea of mapping in Java
		
	}
}
