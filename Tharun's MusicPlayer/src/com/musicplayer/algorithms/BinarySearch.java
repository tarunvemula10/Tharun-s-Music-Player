package com.musicplayer.algorithms;

public class BinarySearch extends Algorithms {

	@Override
	public int binarySearch(String[] list, String targetElement, int startPos, int endPos) {
		if(endPos >= startPos) {
			int mid = startPos+(endPos-startPos)/2;
			if(list[mid].equals(targetElement)) {
				return mid;
			}
			
			if(list[mid].compareTo(targetElement) < 0) {
				return binarySearch(list, targetElement, mid+1, endPos);
			} else if(list[mid].compareTo(targetElement) > 0) {
				return binarySearch(list, targetElement, startPos, mid-1);
			}
		}
		return -1;
	}
}
