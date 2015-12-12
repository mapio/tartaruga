package it.unimi.di.tartaruga;

import static org.junit.Assert.assertTrue;

import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.Arrays;

import org.junit.Test;

public class TestTartaruga {
	
	public static boolean pathsEqual( int[][] expected, final GeneralPath actual ) {
		int i = 0;
		PathIterator pi = actual.getPathIterator( null );
		double[] coords = new double[ 6 ];
		while ( ! pi.isDone() ) {
			int kind = pi.currentSegment( coords );
			if ( ! (   
				expected[ i ][ 0 ] == kind &&
				expected[ i ][ 1 ] == (int)coords[ 0 ] &&
				expected[ i ][ 2 ] == (int)coords[ 1 ]
			) ) {
				System.err.println(  "Expected: " + Arrays.toString( expected[ i ] ) + " actual [" +  kind + ", " + (int)coords[ 0 ] + ", " + (int)coords[ 1 ] + "]" );
				return false;
			}
			pi.next();
			i++;
		}
		return true;
	}
	
	@Test
	public void testInit() {
		Tartaruga t = new Tartaruga();
		int[][] expected = {
			{ PathIterator.SEG_MOVETO, 200, 200 },
		};
		assertTrue( pathsEqual( expected, t.path ) );
	}

	@Test
	public void testAvantiSposta() {
		Tartaruga t = new Tartaruga();
		t.avanti( 50 );
		t.sposta( 50 );
		int[][] expected = {
			{ PathIterator.SEG_MOVETO, 200, 200 },
			{ PathIterator.SEG_LINETO, 250, 200 },
			{ PathIterator.SEG_MOVETO, 300, 200 },
		};
		assertTrue( pathsEqual( expected, t.path ) );
	}

	@Test
	public void testQuadrato() {
		Tartaruga t = new Tartaruga();
		for ( int i = 0; i < 4; i++ ) {
			t.avanti( 100 );
			t.sinistra( 90 );
		}
		int[][] expected = {
			{ PathIterator.SEG_MOVETO, 200, 200 },
			{ PathIterator.SEG_LINETO, 300, 200 },
			{ PathIterator.SEG_LINETO, 300, 100 },
			{ PathIterator.SEG_LINETO, 200, 100 },
			{ PathIterator.SEG_LINETO, 200, 200 }
		};
		assertTrue( pathsEqual( expected, t.path ) );
	}

	@Test
	public void testAngolo() {
		Tartaruga t = new Tartaruga();
		t.destra( 45 );
		t.avanti( 100 );
		t.sinistra( 90 );
		t.avanti( 100 );
		int[][] expected = {
			{ PathIterator.SEG_MOVETO, 200, 200 },
			{ PathIterator.SEG_LINETO, 270, 270 },
			{ PathIterator.SEG_LINETO, 341, 200 }
		};
		assertTrue( pathsEqual( expected, t.path ) );
	}

}