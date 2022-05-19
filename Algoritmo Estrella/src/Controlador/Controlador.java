package Controlador;

import Modelo.Box;
import Modelo.Modelo;

public class Controlador {
	private Modelo modelo;
	public Controlador(Modelo modelo) {
		// TODO Auto-generated constructor stub
		this.modelo = modelo;
	}
	
	public void execution() {
		modelo.execution();
	}
	
	public boolean outOfRange(int fil, int col) {
		return modelo.outOfRange(fil, col);
	}	
	public void expandBox(Box box) {
		modelo.expandBox(box);
	}
	public double distanceToEnd(int fil, int col) {
		return modelo.distanceToEnd(fil, col);
	}
	
	public void findCorrectWay() {
		modelo.encontrarCaminoMinimo();
	}
	public boolean itsEnd(Box box) {
		return modelo.itsEnd(box);
	}
	public boolean itsStart(Box box) {
		return modelo.itsStart(box);
	}
	public void showMap() {
		 modelo.showMap();
	}
	public boolean startExists() {
		return modelo.startExists();
	}
	public boolean endExists() {
		return modelo.endExists();
	}
	public void setStart(int fil, int col) {
		modelo.setStart(fil, col);
	}
	public void setEnd(int fil, int col) {
		modelo.setEnd(fil, col);
	}
	public void setWall(int fil, int col) {
		modelo.setWall(fil, col);
	}
	public Box[][] getMap() {
		return modelo.getMap();
	}
	public boolean getSolution() {
		return modelo.getSolution();
	}
	
	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo(int fil, int col) {
		// TODO Auto-generated method stub
		modelo.setFil(fil);
		modelo.setCol(col);
	}
	public void crearMapa(int f,int c) {
		modelo.crearMapa(f,c);
	}
	
}
