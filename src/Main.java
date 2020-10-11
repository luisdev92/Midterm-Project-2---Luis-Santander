// Programmer: Luis Santander
// Assignment: Midterm Project #2
// Class: CS3310 - Analysis of Algorithms

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class Main {
	
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static int[] getRandomArray(int min, int max, int size) {
		
		int[] A = new int[size]; 
		
		for (int i = 0; i < size; i++) {
			A[i] = getRandomNumber(min, max); 
		}
		
		return A; 
	}
	
	// 1) Brute Force Solution
	public static void BruteForceSolution(int[] A, int sum) {
				
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
	
		for (int i = 0; i < A.length; i++) {
			
			for (int j = 0; j < A.length; j++) {	
				if ((A[i] + A[j]) == sum) {
					table.put(i, j); 
				}
			}
		}
		
		System.out.println("Index locations");
		System.out.println(table.toString());
		System.out.println("Sum = " + sum);
	}

	// 2) Optimal Solution
	public static void OptimalPairSumSolution(int[] A, int sum) {
		
		HashSet<Integer> set = new HashSet<>();
		Hashtable<Integer, Integer> indexLocations = new Hashtable<Integer, Integer>();
		
		for (int i = 0; i < A.length; i++) {
			indexLocations.put(A[i], i);
			set.add(A[i]);
		}
		
		for (int i = 0; i < A.length; i++) {
			int difference = sum - A[i]; 
			
			if (set.contains(difference)) {
				System.out.println("(i=" + indexLocations.get(A[i]) + " v= " + A[i] + ") + (i=" + 
							       indexLocations.get(difference) + " v=" + difference + ") = " + sum);
			}
		
		}
		System.out.println("Index locations above"); 
		System.out.println("Sum = " + sum); 
	}

    // Assuming not Sorted
	public static void RunChosenAlgorithmAssumingNotSorted(int[] A, int sum, int option) {
		Arrays.sort(A);
		if (option == 1) {
			BruteForceSolution(A, sum);
		} else {
			OptimalPairSumSolution(A, sum); 
		}
	}
	
	public static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		// Change the Sample Size
		int sampleSize = 100; 
		
	
		long startTime, endTime; 
		int sum = getRandomNumber(-200, 200); 
		int[] A = getRandomArray(-100, 100, sampleSize);
		
		// Part A - Assume array is sorted. 
		// ------------------------------------------------------------------------
		// Create a Sorted Array. 
		// Arrays.sort(A);
        // printArray(A);
	
//		// Brute Force Solution 
//		startTime = System.currentTimeMillis();
//		BruteForceSolution(A, sum);
//		endTime = System.currentTimeMillis();		
//		System.out.println("Brute force solution time taken: " + (endTime - startTime) + "ms");
		
		
		// Optimal Solution 
//		startTime = System.currentTimeMillis();
//		OptimalPairSumSolution(A, sum);
//		endTime = System.currentTimeMillis();
//		System.out.println("Optimal solution time taken: " + (endTime - startTime) + "ms");
		
		// Part B - Assume array is not sorted (include sorting running time).
		// ------------------------------------------------------------------------
		// Option 1: Brute Force Solution T(n) = O(n^2) + c 
		// Option 2: Optimal Solution T(n) = O(n + k) + O(n * log(n))
		int option = 2; 
		sampleSize = 100;
		
		
		A = getRandomArray(-100, 100, sampleSize);
		System.out.print("Array: {");
		printArray(A);
		System.out.println("}");
		startTime = System.currentTimeMillis();
		RunChosenAlgorithmAssumingNotSorted(A, sum, option);
		endTime = System.currentTimeMillis();
		
		System.out.println("Sample Size: " + sampleSize);
		if (option == 1)
			System.out.println("Brute Force solution time taken: " + (endTime - startTime) + "ms");
		else
			System.out.println("Optimal solution time taken: " + (endTime - startTime) + "ms");
		
	}
}
