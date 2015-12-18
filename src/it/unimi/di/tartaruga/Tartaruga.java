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
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Classe di partenza per la costruzione di un disegno con la tartaruga.
 *
 * <p>Per maggiori informazioni si veda il <a href="{@docRoot}/overview-summary.html">sommario</a> della libreria.</p>
 */
public class Tartaruga {

	/** L'ascissa corrente della tartaruga. */
	private double ascissa;

	/** L'ordinata corrente della tartaruga. */
	private double ordinata;

	/** L'angolo corrente della tartaruga (in radianti). */
	private double radianti;

	/** Il {@link GeneralPath} che memorizza il disegno della tartaruga. */
	GeneralPath path;

	/** Il {@link JPanel} che memorizza il disegno della tartaruga. */
	private JPanel panel;

	/** Prepara la tartaruga.
	 *
	 * @param lato la dimensione dello spazio di disegno.
	 */
	@SuppressWarnings( "serial" )
	public Tartaruga( int lato ) {
		ascissa = lato / 2;
		ordinata = lato / 2;
		radianti = 0;
		path = new GeneralPath();
		path.moveTo( ascissa, ordinata );
		panel = new JPanel() {
			@Override
			protected void paintComponent( Graphics g ) {
				super.paintComponent( g );
				Graphics2D g2 = (Graphics2D)g;
				g2.setColor( Color.WHITE );
				g2.fillRect( 0, 0, getWidth(), getHeight() );
				g2.setColor( Color.BLACK );
				g2.draw( path );
			}
		};
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				f.add( panel );
				f.setSize( lato, lato );
				f.setLocation( 200, 200 );
				f.setVisible( true );
			}
		} );
	}

	/** Prepara la tartaruga con uno spazio di disegno di lato 400. */
	public Tartaruga() {
		this( 400 );
	}

	/** Ruota a sinistra la tartaruga dell'angolo dato.
	 *
	 * @param angolo l'angolo (in gradi) secondo cui ruotare la tartaruga.
	 */
	public void sinistra( int angolo ) {
		this.radianti -= angolo * Math.PI / 180;
	}
	
	/** Ruota a sinistra la tartaruga dell'angolo dato.
	 * 
	 * @param angolo l'angolo (in gradi) secondo cui ruotare la tartaruga.
	 */
	public void sinistra( double angolo ) {
		this.radianti -= angolo * Math.PI / 180;
	}

	/** Ruota a destra la tartaruga dell'angolo dato.
	 *
	 * @param angolo l'angolo (in gradi) secondo cui ruotare la tartaruga.
	 */
	public void destra( int angolo ) {
		this.radianti += angolo * Math.PI / 180;
	}
	
	/** Ruota a destra la tartaruga dell'angolo dato.
	 * 
	 * @param angolo l'angolo (in gradi) secondo cui ruotare la tartaruga.
	 */
	public void destra( double angolo ) {
		this.radianti += angolo * Math.PI / 180;
	}
	
	private void aggiorna( int lunghezza, boolean disegna ) {
		ascissa +=  lunghezza * Math.cos( radianti );
		ordinata += lunghezza * Math.sin( radianti );
		if ( disegna ) path.lineTo( ascissa, ordinata );
		else path.moveTo( ascissa, ordinata );
		panel.repaint();
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

}
