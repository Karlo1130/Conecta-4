import java.awt.Dimension;
import java.awt.Menu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Ventana extends JFrame{
	public Ventana()
	{
		
		this.setIconImage(createImageIcon("icono.png").getImage());
		Dimension ventana = new Dimension(1000, 800);
		
		setSize(ventana);
		setMinimumSize(ventana);
		
		setTitle("-Conecta 4-");//Titulo en la ventana
		
		MenuPrincipal menu = new MenuPrincipal(0);
		 	
		add(menu);//Agrega el objeto dentro de la ventana	
		
	}
	protected ImageIcon createImageIcon(String nombreFigura){
        java.net.URL imgURL = getClass().getResource("img/" + nombreFigura);
        /*si encuentra en la carpeta la imagen indicada*/
        if(imgURL != null){
            return new ImageIcon(imgURL);
        }else{
            /*Devuelve por default la imagen de ficha azul*/
            return new ImageIcon(getClass().getResource("img/sintextura.png"));
        }
    }
}
