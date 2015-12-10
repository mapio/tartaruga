package it.unimi.di.tartaruga.esempi;

import it.unimi.di.tartaruga.Tartaruga;

/**
 * Disegna il <a href="https://en.wikipedia.org/wiki/Sierpinski_triangle">triangolo di Sierpinski</a>.
 */
public class Sierpinski {

	Tartaruga t = new Tartaruga( 600 );
	
	void sierpinski( int lato ) {
		int i;

		if ( lato < 20 )
			for ( i = 0; i < 3; i++ ) {
				t.avanti( lato );
				t.sinistra( 120 );
			}
		else {
			sierpinski( lato / 2 );
			t.sposta( lato / 2 );
			sierpinski( lato / 2 );
			t.sinistra( 120 );
			t.sposta( lato / 2 );
			t.destra( 120 );
			sierpinski( lato / 2 );
			t.sinistra( 240 );
			t.sposta( lato / 2 );
			t.sinistra( 120 );
		}
	}

	public static void main( String[] args ) {
		new Sierpinski().sierpinski( 200 );
	}

}
