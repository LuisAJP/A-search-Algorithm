package Main;

import java.awt.EventQueue;
import Controlador.Controlador;
import Modelo.Modelo;
import Vista.VentanaPrincipal;


public class Main {
public static void main(String[] args) {
		
		Modelo modelo = new Modelo(1,1);
		Controlador controlador = new Controlador(modelo);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VentanaPrincipal  vista = new VentanaPrincipal(controlador);
				vista.setVisible(true);
			}});
	}

}
