package com.musicplayer.algorithms;

import java.util.concurrent.TimeUnit;

public class Time {
	public static void wait(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}