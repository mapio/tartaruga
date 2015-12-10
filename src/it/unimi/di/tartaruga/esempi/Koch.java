package it.unimi.di.tartaruga.esempi;

import it.unimi.di.tartaruga.Tartaruga;

/**
 * Disegna il <a href="https://en.wikipedia.org/wiki/Koch_snowflake">fiocco di neve di Koch</a>. 
 */
public class Koch {

	Tartaruga t = new Tartaruga( 600 );

	void koch( int lato ) {
		if ( lato < 10 )
			t.avanti( lato );
		else {
			koch( lato / 3 );
			t.sinistra( 60 );
			koch( lato / 3 );
			t.destra( 120 );
			koch( lato / 3 );
			t.sinistra( 60 );
			koch( lato / 3 );
		}
	}

	public static void main( String[] args ) {
		new Koch().koch( 250 );
	}
	
}
