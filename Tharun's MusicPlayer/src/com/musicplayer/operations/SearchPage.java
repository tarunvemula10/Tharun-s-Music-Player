package com.musicplayer.operations;

import com.musicplayer.algorithms.Search;

public class SearchPage implements MusicOperations {
	
	private SearchPage() { }
	private static SearchPage instance = null;
	
	@Override
	public void searchSong(String[] songsList, String targetSong) {
		
		boolean result = Search.findTarget(songsList, targetSong);
		
		if(result == true) {
			HomePage.getInstance().playSingle(targetSong);
		} else {
			System.err.println("No Results Found :(");
		}
	}

	@Override
	public void playSingle(String song) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playAllTracks(String[] songsList) {
		// TODO Auto-generated method stub
		
	}
	
	public static SearchPage getInstance() {
		if(instance==null) {
			return new SearchPage();
		}
		return instance;
	}
}
