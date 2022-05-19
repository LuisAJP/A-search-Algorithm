package Modelo;

import javax.swing.JButton;

public class Box extends JButton{
	
	private int type;
	private int fil;
	private int col;
	private int fatherfil;
	private int fathercol;
	private double value;
	
	public Box() {}
	
	/*Setters and Getters*/
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getBoxfil() {
		return this.fil;
	}
	public void setBoxfil(int fil) {
		this.fil = fil;
	}
	public void setBoxcol(int col) {
		this.col = col;
	}
	public int getBoxcol() {
		return this.col;
	}
	public void setFatherfil(int fil) {
		this.fatherfil = fil;
	}
	public int getFatherfil() {
		return this.fatherfil;
	}
	public void setFathercol(int col) {
		this.fathercol = col;
	}
	public int getFathercol() {
		return this.fathercol;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getValue() {
		return this.value;
	}
}