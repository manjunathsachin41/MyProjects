package com.example.constructor;

public class SonnetSong implements Poem {

	private static String[] LINES = { "Johny Johny Yes Papa" };

	@Override
	public void recite() {
		System.out.print("PoeticJuggler Sonnet Song : ");
		for (int i = 0; i < LINES.length; i++) {
			System.out.println(LINES[i]);
		}
	}

}
