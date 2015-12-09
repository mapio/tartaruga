package it.unimi.di.tartaruga;

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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Classe di partenza per la costruzione di un disegno con la tartaruga.
 */
public abstract class Tartaruga {

	/** Il lato del {@link JPanel} visualizzato. */
	private final int lato;
	
	/** Il {@link Graphics2D} avuto come argomento dal metodo {@link JPanel#paintComponent(Graphics2D)}. */
	private Graphics2D g2;
	
	/** L'angolo corrente della tartaruga (in radianti). */
	private double radianti;
	
	/** L'ascissa corrente della tartaruga. */
	private double ascissa;
	
	/** L'ordinata corrente della tartaruga. */
	private double ordinata;

	/** Prepara la tartaruga. 
	 * 
	 * @param lato la dimensione dello spazio di disegno.
	 */
	public Tartaruga( int lato ) {
		this.lato = lato;
		this.g2 = null;
		this.ascissa = 0;
		this.ordinata = 0;
		this.radianti = 0;
	}
	
	/** Prepara la tartaruga con uno spazio di disegno di lato 400. */
	public Tartaruga() {
		this( 400 );
	}
	
	/** Ruota a sinistra la tartaruda dell'angolo dato.
	 * 
	 * @param angolo l'angolo (in gradi) secondo cui ruotare la tartaruga.
	 */
	public void sinistra( int angolo ) {
		this.radianti -= angolo * Math.PI / 180;
	}

	/** Ruota a destra la tartaruda dell'angolo dato.
	 * 
	 * @param angolo l'angolo (in gradi) secondo cui ruotare la tartaruga.
	 */
	public void destra( int angolo ) {
		this.radianti += angolo * Math.PI / 180;
	}

	private void aggiorna( int lunghezza, boolean disegna ) {
		if ( g2 == null ) throw new IllegalStateException( "Non è possibile disegnare prima di aver invocato il metodo disegna!" );
		double nuovaAscissa = ascissa + lunghezza * Math.cos( radianti );
		double nuovaOrdinata = ordinata + lunghezza * Math.sin( radianti );
		if ( disegna ) 
			g2.drawLine( (int)ascissa, (int)ordinata, (int)nuovaAscissa, (int)nuovaOrdinata );
		ascissa = nuovaAscissa;
		ordinata = nuovaOrdinata;
	}

	/**
	 * Fa muovere (disegnando) in avanti la tartaruga della lunghezza data.
	 *  
	 * @param lunghezza la lunghezza secondo cui muovere la tartaruga.
	 */
	public void avanti( int lunghezza ) {
		aggiorna( lunghezza, true );
	}

	/**
	 * Fa spostare (non disegnando) in avanti la tartaruga della lunghezza data.
	 *  
	 * @param lunghezza la lunghezza secondo cui sopstare la tartaruga.
	 */
	public void sposta( int lunghezza ) {
		aggiorna( lunghezza, false );
	}

	/**
	 * Questo metodo, da implementare nelle sottoclassi astratte
	 * di {@link Tartaruga}, deve contenere le istruzioni secondo 
	 * cui la tartaruga farà il suo disegno una volta invocato il 
	 * metodo {@link #disegna()}.
	 */
	public abstract void istruzioni();

	/**
	 * Questo metodo ordina alla tartaruga di disegnare secondo 
	 * le istruzioni contenute nel metodo {@link #istruzioni()}.
	 */
	@SuppressWarnings( "serial" )
	public final void disegna() {
		SwingUtilities.invokeLater( new Runnable() {

			public void run() {

				JFrame f = new JFrame();
				f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				f.add( new JPanel() {

					protected void paintComponent( Graphics g ) {
						super.paintComponent( g );
						g2 = (Graphics2D)g;

						int h = getHeight();
						int w = getWidth();
						ascissa = w / 2;
						ordinata = h / 2;

						g2.setColor( Color.WHITE );
						g2.fillRect( 0, 0, w, h );
						g2.setColor( Color.BLACK );

						istruzioni();
					}

				} );
				f.setSize( lato, lato );
				f.setLocation( 200, 200 );
				f.setVisible( true );
			}
		} );
	}

}
