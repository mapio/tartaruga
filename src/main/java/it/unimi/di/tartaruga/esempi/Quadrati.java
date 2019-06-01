package it.unimi.di.tartaruga.esempi;

/*
 * Copyright 2015 Massimo Santini
 *
 * This file is part of tartaruga.
 *
 * tartaruga is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * tartaruga is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * tartaruga. If not, see <http://www.gnu.org/licenses/>.
 */

import it.unimi.di.tartaruga.Tartaruga;

/**
 * Disegna una serie di quadrati ruotati.
 */
public class Quadrati {

	public static void main( String[] args ) {
		Tartaruga t = new Tartaruga();

		int n = 10;
		for ( int j = 0; j < 360 / n; j++ ) {
			for ( int i = 0; i < 4; i++ ) {
				t.avanti( 100 );
				t.destra( 90 );
			}
			t.destra( n );
		}


	}

}
