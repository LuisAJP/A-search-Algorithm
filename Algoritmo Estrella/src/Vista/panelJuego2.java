package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.Box;
import Modelo.Modelo;

public class panelJuego2 extends JFrame{
	private int fil;
	private int col;
	private Box[][] map;
	private Modelo modelo;
	JLabel mensaje1 = new JLabel();
	JLabel mensaje2 = new JLabel();

	public panelJuego2(Modelo modelo, int fil, int col) {
		this.fil = fil;
		this.col = col;
		this.map = modelo.getMap();
		this.modelo= modelo;
			
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null); 
		setTitle("Algoritmo A*"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box box;
		JPanel finalMapPanel = new JPanel();
		finalMapPanel.setLayout(new GridLayout(this.fil, this.col));
		for (int i = 0; i < fil; i++) {
			for (int j = 0; j < col; j++) {
				box = this.map[i][j];
				finalMapPanel.add(box);
				if (box.getType() == 0) box.setBackground(Color.blue);
				else if (box.getType() == 1) box.setBackground(Color.RED);
				else if (box.getType() == 2) box.setBackground(Color.black);
				else if (box.getType() == 3) {
					box.setBackground(Color.pink);
				}
				
				else {
					
					box.setBackground(Color.green);
					box.setOpaque(true);
				}
			}
		}
		
		JPanel mensaje2s = new JPanel();
		mensaje2s.setLayout(new GridLayout(2, 1));
		if (this.modelo.getSolution() == true) {
			this.mensaje1.setText("Exito!");
			this.mensaje1.setHorizontalAlignment(JLabel.CENTER);
			this.mensaje2.setText("Ha encontrado el camino.");
			this.mensaje2.setHorizontalAlignment(JLabel.CENTER);
		}
		else {
			this.mensaje1.setText("Error!");
			this.mensaje1.setHorizontalAlignment(JLabel.CENTER);
			this.mensaje2.setText("No existe un camino.");
			this.mensaje2.setHorizontalAlignment(JLabel.CENTER);
		}
		mensaje2s.add(mensaje1);
		mensaje2s.add(mensaje2);
		
		setLayout(new BorderLayout());
		add(finalMapPanel, BorderLayout.CENTER);
		add(mensaje2s, BorderLayout.PAGE_END);
		add(finalMapPanel);
	}
}