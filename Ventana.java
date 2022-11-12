import java.awt.Dimension;
import java.awt.Menu;

import javax.swing.JFrame;


public class Ventana extends JFrame{
	public Ventana()
	{
		
		Dimension ventana = new Dimension(1000, 800);
		
		setSize(ventana);
		setMinimumSize(ventana);
		
		setTitle("Conecta 4");//Titulo en la ventana
		
		MenuPrincipal menu = new MenuPrincipal();
		 	
		add(menu);//Agrega el objeto dentro de la ventana	
		
	}
}
