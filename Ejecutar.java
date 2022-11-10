import javax.swing.JFrame;

public class Ejecutar {
	public static void main(String[] args) {
		Ventana aplicacion = new Ventana();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*Al presionar X, cierra la ventana y el programa.*/
		//aplicacion.pack();/*redimensiona autom�ticamente el tama�o de la ventana al espacio ocupado por los botones.*/
		aplicacion.setVisible(true);/*Hace visible el Frame o la ventana.*/
		aplicacion.setLocationRelativeTo(null);/*Coloca la ventana al centro del monitor*/
	}
}
