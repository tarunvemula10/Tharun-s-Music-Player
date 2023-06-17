package com.musicplayer.operations;
import com.musicplayer.algorithms.Time;

public class HomePage implements MusicOperations {
	
	private HomePage() { }
	private static HomePage instance = null;

	@Override
	public void playSingle(String song) {
		// Plays the specified song
		System.out.println("Playing "+song+".....");
		Time.wait(10); // proceeds for next operation after 10 seconds
	}

	@Override
	public void playAllTracks(String[] songsList) {
		// songs will run in loop from given list
		for(int i=0; i<songsList.length; i++) {
			System.out.println("Playing "+songsList[i]+".....");
			Time.wait(10); // after every 10 seconds the song will change
		}
	}

	@Override
	public void searchSong(String[] songsList, String targetSong) {
		// TODO Auto-generated method stub
		
	}
	
	//singleton class
	public static HomePage getInstance() {
		if(instance==null) {
			return new HomePage();
		}
		return instance;
	}
}
