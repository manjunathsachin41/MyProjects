package com.example.constructor;

public class PoeticJuggler extends Juggler {
	
	private Poem poem;
	
	public PoeticJuggler(Poem poem) {
		this.poem = poem ;
	}
	
	public PoeticJuggler(int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem ;
	}
	
	public void perform() {
		poem.recite();
	}

}
