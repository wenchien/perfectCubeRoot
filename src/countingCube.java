import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//inspired by https://www.youtube.com/watch?v=Ds8ijPsg26g

class CubeStructure {
	private HashMap<Integer, Integer> table;
	private HashMap<Integer, Integer> cubeTable;
	private int[] cubeArray = {1, 8, 27, 64, 125, 216, 343, 512, 729, 1000};
	public CubeStructure() {
		table = new HashMap<>();
		cubeTable = new HashMap<>();
		System.out.println("Table initialized, make sure you use the generate function before calling findPerfectCubeRoot");
	}
	
	public void generate() {
		//last digit table
		table.put(1, 1);
		table.put(4, 4);
		table.put(5, 5);
		table.put(6, 6);
		table.put(9, 9);
		table.put(10, 0);
		table.put(0, 0);
		
		table.put(2, 8);
		table.put(3, 7);
		table.put(8, 2);
		table.put(7, 3);
		
		//cube table
		cubeTable.put(1, 1);
		cubeTable.put(8, 2);
		cubeTable.put(27, 3);
		cubeTable.put(64, 4);
		cubeTable.put(125, 5);
		cubeTable.put(216, 6);
		cubeTable.put(343, 7);
		cubeTable.put(512, 8);
		cubeTable.put(729, 9);
		cubeTable.put(1000, 10);
	}
	
	public void findPerfectCubeRoot(int input) {
		String result = "";
		int lastDigit = 0;
		int temp = 0;
		
		//if input value is lower than the 1000 threshold, then just return the corresponding value from the look up table
		if (input < 1000) {
			temp = cubeTable.get(input);
			System.out.println("The cube root of the number " + input + " is: " + temp);
		}
		else if (input >= 1000) {
			//find last digit of input first
			lastDigit = input % 10;
			lastDigit = table.get(lastDigit);
			
			//now divide by 1000 and use the result to find the nearest number using the lookup table
			temp = input / 1000;
			temp = findClosest(temp);
			temp = cubeTable.get(temp);
			System.out.println("The cube root of the number " + input + " is: " + temp + lastDigit);
		}
	}
	
	public int findClosest(int target) {
		int n = cubeArray.length;
		
		//corner cases, first and last element
		if (target <= cubeArray[0]) {
			return cubeArray[0];
		}
		if (target >= cubeArray[n - 1]) {
			return cubeArray[n - 1];
		}
		
		//binarySearch
		int first = 0, last = n, mid = 0;
		while (first < last) {
			mid = (first + last) / 2;
			
			//if find at mid, then return it
			if (cubeArray[mid] == target) {
				return cubeArray[mid];
			}
			
			//if we didn't find it do left right search
			//search left
			if (target < cubeArray[mid]) {
				//if target is bigger than previous element of mid, return closest of two
				if (mid > 0 && target > cubeArray[mid - 1]) {
					return getClosest(cubeArray[mid - 1], cubeArray[mid], target);
				}
				//repeat left half, keep cutting half
				last = mid;
			}
			else {
				if (mid < n - 1 && target < cubeArray[mid + 1]) {
					return getClosest(cubeArray[mid], cubeArray[mid + 1], target);
				}
				first = mid + 1;
			}
		}
		
		return cubeArray[mid];
	}
	
	public int getClosest(int value1, int value2, int target) {
		//can be changed with Math.abs?
		if (target - value1 >= value2 - target) {
			return value2;
		}
		else {
			return value1;
		}
	}
	
}

public class countingCube {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		CubeStructure cube1 = new CubeStructure();
		cube1.generate();
		cube1.findPerfectCubeRoot(input);
		scan.close();
	}
}
