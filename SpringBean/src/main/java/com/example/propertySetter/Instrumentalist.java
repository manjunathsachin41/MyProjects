package com.example.propertySetter;

import com.example.constructor.Performer;

public class Instrumentalist implements Performer {
	
	private String song ;
	
	private Instrument instrument;

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() {
		instrument.play();
		System.out.println(song);
	}

}
