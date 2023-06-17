package com.musicplayer.algorithms;

public class QuickSort extends BinarySearch {

	@Override
	public void quickSort(String[] list, int low, int high) {
		if(high>low) {
			int pivotIndex = partition(list, low, high);
			
			quickSort(list, low, pivotIndex-1);
			quickSort(list, pivotIndex+1, high);
		}
	}

	private int partition(String[] list, int low, int high) {
		
		String pivot = list[high];
		int i = low-1;
		
		for(int j=low; j<high; j++) {
			if(list[j].compareTo(pivot) < 0) {
				i++;
				//swap
				String temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		i++;
		String temp = list[i];
		list[i] = pivot;
		list[high] = temp;
		
		return i;
	}
}
