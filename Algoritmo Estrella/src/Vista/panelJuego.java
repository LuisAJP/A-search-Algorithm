package Vista;

import javax.swing.JPanel;

import Controlador.Controlador;
import Modelo.Box;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class panelJuego extends JPanel {

	/**
	 * Create the panel.
	 */
	//private Box box;
	private int fil;
	private int col;
	private int boxValue;
	private Controlador controlador;
	public panelJuego(int fil, int col, Controlador controlador) {
		this.boxValue = -1;
		setLayout(new BorderLayout(0, 0));
		this.fil=fil;
		this.col=col;
		this.controlador=controlador;
		controlador.setModelo(fil,col);
		controlador.crearMapa(fil, col);
		JPanel panelTablero = new JPanel();
		add(panelTablero, BorderLayout.CENTER);
		panelTablero.setLayout(new GridLayout(fil,col));
		 
		for(int i=0; i<fil;i++) {
			
			for(int j=0; j<col;j++) {
				Box box = new Box();
				box.setBoxfil(i);
				box.setBoxcol(j);
				box.setBackground(Color.green);
				
				panelTablero.add(box);
				box.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (getBoxValue() == 0) {
							if (!controlador.startExists()) {
								setStart(box);
								box.setBackground(Color.BLUE);
							
								box.setOpaque(true);
							}			
						}
						else if (getBoxValue() == 1) {
							if (!controlador.endExists()) {
								setEnd(box);
								
								box.setBackground(Color.red);
								box.setOpaque(true);
							}
						}
						else if (getBoxValue() == 2) {
							setWall(box);
							box.setBackground(Color.black);
							
							box.setOpaque(true);
						} 
					}
				});
				
			}
		}
		
		JPanel panelBotones = new JPanel();
		
		panelBotones.setPreferredSize(new Dimension(50,50));
		
		add(panelBotones, BorderLayout.SOUTH);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelBotones.rowHeights = new int[]{0, 0};
		gbl_panelBotones.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		JButton btnIni = new JButton("Inicio");
		GridBagConstraints gbc_btnIni = new GridBagConstraints();
		gbc_btnIni.insets = new Insets(0, 0, 0, 5);
		gbc_btnIni.gridx = 0;
		gbc_btnIni.gridy = 0;
		panelBotones.add(btnIni, gbc_btnIni);
		
		JButton btnFin = new JButton("Fin");
		GridBagConstraints gbc_btnFin = new GridBagConstraints();
		gbc_btnFin.insets = new Insets(0, 0, 0, 5);
		gbc_btnFin.gridx = 1;
		gbc_btnFin.gridy = 0;
		panelBotones.add(btnFin, gbc_btnFin);
		
		JButton btnObs = new JButton("Obstaculo");
		GridBagConstraints gbc_btnObs = new GridBagConstraints();
		gbc_btnObs.gridx = 2;
		gbc_btnObs.gridy = 0;
		panelBotones.add(btnObs, gbc_btnObs);
		
		JButton btnEjecutar = new JButton("ejecutar");
		GridBagConstraints gbc_btnEjecutar = new GridBagConstraints();
		gbc_btnObs.gridx = 3;
		gbc_btnObs.gridy = 0;
		panelBotones.add(btnEjecutar, gbc_btnEjecutar);
		
		
		
		/*Start button*/
		btnIni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBoxValue(0);
			}
		});
		btnFin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBoxValue(1);
			}
		});
		btnObs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBoxValue(2);
			}
		});
		btnEjecutar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!controlador.startExists() || !controlador.endExists()) 
					JOptionPane.showMessageDialog(null, "ERROR: Please enter the start point "
							+ "and the end point.");
				else {
					controlador.execution();
					updateMap();
				}
			}
		});
		
		

	}
	public int getBoxValue() {
		return this.boxValue;
	}
	
	public void setBoxValue(int boxValue) {
		this.boxValue = boxValue;
	}
	public void updateMap() {
		panelJuego2 finalMap = new panelJuego2(controlador.getModelo(), this.fil, this.col);
		//setVisible(false);
		finalMap.setVisible(true);
		
	}
	
	public void setStart(Box box) {
		this.controlador.setStart(box.getBoxfil(), box.getBoxcol());
	}
	public void setEnd(Box box) {
		this.controlador.setEnd(box.getBoxfil(), box.getBoxcol());
	}
	public void setWall(Box box) {
		this.controlador.setWall(box.getBoxfil(), box.getBoxcol());
	}

}
