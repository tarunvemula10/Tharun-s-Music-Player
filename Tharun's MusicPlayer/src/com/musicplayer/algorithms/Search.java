package com.musicplayer.algorithms;

public class Search {
	public static boolean findTarget(String[] songsList ,String searchSong) {
		
		//first we need to sort the list in order to search
		Algorithms algorithms = new QuickSort();
		algorithms.quickSort(songsList, 0, songsList.length-1);
		
		//after sorting taking the same array and searching and then storing the value
		int result = algorithms.binarySearch(songsList, searchSong, 0, songsList.length-1)+1;
		
		//comparing the value with zero and the giving the boolean value
		if(result>0) {
			return true;
		}
		return false;
	}
}
