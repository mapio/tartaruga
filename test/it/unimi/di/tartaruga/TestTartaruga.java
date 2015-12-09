package it.unimi.di.tartaruga;

import org.junit.Test;


public class TestTartaruga {
	
	static class Tester extends Tartaruga {
		@Override
		public void istruzioni() {}
	}
	
	@Test( expected = IllegalStateException.class )
	public void testDisegna() {
		Tester tester = new Tester();
		tester.avanti( 10 );
	}

}