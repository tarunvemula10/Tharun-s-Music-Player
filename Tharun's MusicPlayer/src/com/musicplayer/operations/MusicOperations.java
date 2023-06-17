package com.musicplayer.operations;

public interface MusicOperations {
	
	//play operations
	public void playSingle(String song); //to play single track
	public void playAllTracks(String[] songsList); //to play all tracks
	
	// to search the specified song
	public void searchSong(String[] songsList, String targetSong);
	
	
}