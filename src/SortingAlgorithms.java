// Sorting class used to sort ArrayList<Integer>
// Have Insertion sort and MergeSort ready with testing code

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithms {

	public static void main(String[] args) {
		
		//Generate an arrayList with random integers
		int arraySize = 100000; 
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < arraySize; i++) {
			numbers.add((int)(Math.random() * 1000));
		}
		
		//Create sorter object to sort random arrayList
		SortingAlgorithms sorter = new SortingAlgorithms();
						
		//Test Insertion or Merge sort and clock algorithm runtime
		long startTime = System.currentTimeMillis();
		//sorter.MergeSort(numbers, 0, numbers.size()-1);
		sorter.InsertionSort(numbers);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Sorting " + arraySize + " numbers took " + totalTime + " milliseconds");

		//Test to make sure arrayList is sorted
		sorter.isSorted(numbers);
	}
//==================================================================================
	
	// Insertion Sort Algorithm
	// Time complexity: O(n^2)
	// Space Complexity: O(1)
	public ArrayList<Integer> InsertionSort(ArrayList<Integer> nums) {
		for(int i = 1; i < nums.size(); i++) {
			int current = nums.get(i);
			int j = i;
			while(j !=0 && current < nums.get(j-1)) {
				nums.set(j, nums.get(j-1));
				nums.set(j-1, current);
				j--;
			}
		}
		return nums;
	}
	
//==================================================================================
	
	// Merge Sort Algorithm
	// Time complexity: O(n*log(n))
	// Space Complexity: O(n)
	public ArrayList<Integer> MergeSort(ArrayList<Integer> A, int p, int r){
		if(p < r) {
			int q = ((r-p) / 2) + p;
			MergeSort(A, p, q); // Recursive call for half of list
			MergeSort(A, q+1, r);
			Merge(A, p, q, r);
		}
		
		return A;
	}
	
	// Merge function used to sort sublists; Used in MergeSort
	public ArrayList<Integer> Merge(ArrayList<Integer> A, int p, int q, int r){
		
		List<Integer> L = new ArrayList<Integer>();
		List<Integer> R = new ArrayList<Integer>();
		
		L.addAll(A.subList(p, q+1));
		R.addAll(A.subList(q+1, r+1));
		
		//Added to the end of each array as a sentient infinity value
		L.add(Integer.MAX_VALUE);
		R.add(Integer.MAX_VALUE);
		
		int i = 0; // Variable used for L arrayList
		int j = 0; // Variable used for R arrayList
		
		// Merge ArrayList L and R back into A
		for(int k = p; k <= r; k++) {
			if(L.get(i).compareTo(R.get(j)) <= 0) {
				A.set(k, L.get(i));
				i++;
			}
			else {
				A.set(k, R.get(j));
				j++;
			}
		}
		return A;
	}

//===================================================================================	
	
	// Test method to check if Integer array is in sorted order
	public int isSorted(ArrayList<Integer> A) {
		int previous = A.get(0);
		for(Integer num : A) {
			if(num < previous) {
				System.out.println("This array is NOT sorted");
				return 0;
			}
			previous = num;
		}
		System.out.println("This array is sorted");
		return 1;
	}
}

//===================================================================================
