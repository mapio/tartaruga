package it.unimi.di.tartaruga.esempi;

import it.unimi.di.tartaruga.Tartaruga;

/**
 * Disegna il <a href="https://en.wikipedia.org/wiki/Koch_snowflake">fiocco di neve di Koch</a>. 
 */
public class Koch extends Tartaruga {

	public Koch( int lato ) {
		super( lato );
	}

	void koch( int lato ) {
		if ( lato < 10 )
			avanti( lato );
		else {
			koch( lato / 3 );
			sinistra( 60 );
			koch( lato / 3 );
			destra( 120 );
			koch( lato / 3 );
			sinistra( 60 );
			koch( lato / 3 );
		}
	}

	@Override
	public void istruzioni() {
		koch( 250 );
	}

	public static void main( String[] args ) {
		new Koch( 600 ).disegna();
	}
	
}
