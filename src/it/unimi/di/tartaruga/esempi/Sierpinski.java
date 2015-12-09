package it.unimi.di.tartaruga.esempi;

import it.unimi.di.tartaruga.Tartaruga;

/**
 * Disegna il <a href="https://en.wikipedia.org/wiki/Sierpinski_triangle">triangolo di Sierpinski</a>.
 */
public class Sierpinski extends Tartaruga {

	public Sierpinski( int lato ) {
		super( lato );
	}

	void sierpinski( int lato ) {
		int i;

		if ( lato < 20 )
			for ( i = 0; i < 3; i++ ) {
				avanti( lato );
				sinistra( 120 );
			}
		else {
			sierpinski( lato / 2 );
			sposta( lato / 2 );
			sierpinski( lato / 2 );
			sinistra( 120 );
			sposta( lato / 2 );
			destra( 120 );
			sierpinski( lato / 2 );
			sinistra( 240 );
			sposta( lato / 2 );
			sinistra( 120 );
		}
	}

	@Override
	public void istruzioni() {
		sierpinski( 200 );
	}

	public static void main( String[] args ) {
		new Sierpinski( 600 ).disegna();
	}

}
