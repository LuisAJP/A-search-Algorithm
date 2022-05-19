package Modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;




public class Modelo {
	private int fil; 
	private int col;  
	private Box[][] map; 
	private int inicioFil;
	private int inicioCol;
	private int finFil;
	private int finCol;
	private PriorityQueue<Box> listaAbierta;
	private ArrayList<Box> listaCerrada;
	private boolean solution = true;

	public Modelo(int fil, int col) {
		this.fil = fil;
		this.col = col;
		this.inicioFil = -1;
		this.inicioCol = -1;
		this.finFil = -1;
		this.finCol = -1;
		this.map = new Box[fil][col];
		Comparator<Box> comparator = new BoxComparator();
		this.listaAbierta = new PriorityQueue<Box>(fil * col, comparator);
		this.listaCerrada = new ArrayList<Box>();
		
		for (int i = 0; i < fil; i++) {
			for (int j = 0; j < col; j++) {
				Box box = new Box();
				box.setBoxfil(i);
				box.setBoxcol(j);
				box.setType(4);
				this.map[i][j] = box;
			}
		}
	}

	/*Functions for Algorithm A**/
	public boolean outOfRange(int row, int column) {
		return (row < 0 || row >= this.fil || column < 0 || column >= this.col);
	}	
	
	public void expandBox(Box box) {
		int row = box.getBoxfil();
		int column = box.getBoxcol();

		/*Box de arriba*/
		if (!outOfRange(row - 1, column) && 
				!this.listaCerrada.contains(this.map[row - 1][column]) &&
				!this.listaAbierta.contains(this.map[row - 1][column])) {

			this.map[row - 1][column].setFatherfil(row);
			this.map[row - 1][column].setFathercol(column);
			this.map[row - 1][column].setValue(1 + distanceToEnd(row - 1, column));
			this.listaAbierta.add(this.map[row - 1][column]);
		}

		/*Box de derecha/arriba*/
		if (!outOfRange(row - 1, column + 1) && 
				!this.listaCerrada.contains(this.map[row - 1][column + 1]) &&
				!this.listaAbierta.contains(this.map[row - 1][column + 1])) {

			this.map[row - 1][column + 1].setFatherfil(row);
			this.map[row - 1][column + 1].setFathercol(column);
			this.map[row - 1][column + 1].setValue(Math.sqrt(2) + distanceToEnd(row - 1, column + 1));
			this.listaAbierta.add(this.map[row - 1][column + 1]);
		}

		/*Box de derecha*/
		if (!outOfRange(row, column + 1) && 
				!this.listaCerrada.contains(this.map[row][column + 1]) &&
				!this.listaAbierta.contains(this.map[row][column + 1])) {

			this.map[row][column + 1].setFatherfil(row);
			this.map[row][column + 1].setFathercol(column);
			this.map[row][column + 1].setValue(1 + distanceToEnd(row, column + 1));
			this.listaAbierta.add(this.map[row][column + 1]);
		}

		/*Box de derecha/abajo*/
		if (!outOfRange(row + 1, column + 1) && 
				!this.listaCerrada.contains(this.map[row + 1][column + 1]) &&
				!this.listaAbierta.contains(this.map[row + 1][column + 1])) {

			this.map[row + 1][column + 1].setFatherfil(row);
			this.map[row + 1][column + 1].setFathercol(column);
			this.map[row + 1][column + 1].setValue(Math.sqrt(2) + distanceToEnd(row + 1, column + 1));
			this.listaAbierta.add(this.map[row + 1][column + 1]);
		}

		/*Box de abajo*/
		if (!outOfRange(row + 1, column) && 
				!this.listaCerrada.contains(this.map[row + 1][column]) &&
				!this.listaAbierta.contains(this.map[row + 1][column])) {

			this.map[row + 1][column].setFatherfil(row);
			this.map[row + 1][column].setFathercol(column);
			this.map[row + 1][column].setValue(1 + distanceToEnd(row + 1, column));
			this.listaAbierta.add(this.map[row + 1][column]);
		}

		/*Box de izquierda/abajo*/
		if (!outOfRange(row + 1, column - 1) && 
				!this.listaCerrada.contains(this.map[row + 1][column - 1]) &&
				!this.listaAbierta.contains(this.map[row + 1][column - 1])) {

			this.map[row + 1][column - 1].setFatherfil(row);
			this.map[row + 1][column - 1].setFathercol(column);
			this.map[row + 1][column - 1].setValue(Math.sqrt(2) + distanceToEnd(row + 1, column - 1));
			this.listaAbierta.add(this.map[row + 1][column - 1]);
		}

		/*Box de izquerda*/
		if (!outOfRange(row, column - 1) && 
				!this.listaCerrada.contains(this.map[row][column - 1]) &&
				!this.listaAbierta.contains(this.map[row][column - 1])) {

			this.map[row][column - 1].setFatherfil(row);
			this.map[row][column - 1].setFathercol(column);
			this.map[row][column - 1].setValue(1 + distanceToEnd(row, column - 1));
			this.listaAbierta.add(this.map[row][column - 1]);
		}

		/*Box de izquerda/arriba*/
		if (!outOfRange(row - 1, column - 1) && 
				!this.listaCerrada.contains(this.map[row - 1][column - 1]) &&
				!this.listaAbierta.contains(this.map[row - 1][column - 1])) {

			this.map[row - 1][column - 1].setFatherfil(row);
			this.map[row - 1][column - 1].setFathercol(column);
			this.map[row - 1][column - 1].setValue(Math.sqrt(2) + distanceToEnd(row - 1, column - 1));
			this.listaAbierta.add(this.map[row - 1][column - 1]);
		}
	}
	public double distanceToEnd(int row, int column) {
		double x = this.finCol - column;
		double y = this.finFil - row;
		return Math.sqrt((x * x) + (y * y));
	}
	public void execution() {
		Box box = this.listaAbierta.peek();
		this.listaAbierta.poll();
		this.listaCerrada.add(box);
		expandBox(box);
		boolean end = false;
		while (!this.listaAbierta.isEmpty() && !end) {
			box = this.listaAbierta.peek();
			this.listaAbierta.poll();
			this.listaCerrada.add(box);
			if (!itsEnd(box)) expandBox(box);
			else end = true;
		}

		if (this.listaAbierta.isEmpty() && !itsEnd(box)) this.solution = false;
		else {
			encontrarCaminoMinimo();
		}
	}
	public void encontrarCaminoMinimo() {
		int i = this.listaCerrada.size() - 2;
		Box box = this.listaCerrada.get(i);
		while (!itsStart(box)) {
			this.map[box.getBoxfil()][box.getBoxcol()].setType(3);
			box = this.map[box.getFatherfil()][box.getFathercol()];
		}
	}

	/*Additional functions*/
	public boolean itsEnd(Box box) {
		return (box.getBoxfil() == this.finFil && box.getBoxcol() == this.finCol);
	}
	public boolean itsStart(Box box) {
		return (box.getBoxfil() == this.inicioFil && box.getBoxcol() == this.inicioCol);
	}
	public void showMap() {
		int type;
		System.out.print("  ");
		for (int j = 0; j < col; j++) {
			System.out.print(j + 1 + " ");
		}
		System.out.println();

		for (int i = 0; i < fil; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < col; j++) {
				type = this.map[i][j].getType();
				if (type == 0) System.out.print("S");
				else if (type == 1) System.out.print("E");
				else if (type == 2) System.out.print("X");
				else if (type == 3) System.out.print(".");
				else System.out.print(" ");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public boolean startExists() {
		return (this.inicioFil != -1 && this.inicioCol != -1);
	}
	public boolean endExists() {
		return (this.finFil != -1 && this.finCol != -1);
	}
	
	/*Setters and Getters*/
	public void setStart(int row, int column) {
		this.inicioFil = row;
		this.inicioCol = column;
		this.map[inicioFil][inicioCol].setType(0);
		this.listaAbierta.add(map[inicioFil][inicioCol]);
	}
	public void setEnd(int row, int column) {
		this.finFil = row;
		this.finCol = column;
		this.map[finFil][finCol].setType(1);
	}
	public void setWall(int row, int column) {
		map[row][column].setType(2);
		this.listaCerrada.add(map[row][column]);
	}
	public Box[][] getMap() {
		return this.map;
	}
	public boolean getSolution() {
		return this.solution;
	}

	public void setFil(int fil) {
		// TODO Auto-generated method stub
		this.fil=fil;
		
	}

	public void setCol(int col) {
		// TODO Auto-generated method stub
		this.col=col;
	}
	
	public void crearMapa(int f, int c) {
		this.map = new Box[fil][col];
		for (int i = 0; i < fil; i++) {
			for (int j = 0; j < col; j++) {
				Box box = new Box();
				box.setBoxfil(i);
				box.setBoxcol(j);
				box.setType(4);
				this.map[i][j] = box;
			}
		}
	}

}
