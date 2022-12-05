import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class CrearBoton extends JButton {
	private Sound2 sonido;
	private Sound2 sonido2;
	private ImageIcon botonImagen;
		
		
		public CrearBoton (int anchura, int altura){
			sonido= new Sound2("Pop");
			sonido2= new Sound2("Pop2");
			this.setBorderPainted(false);//elimina el borde
			this.setOpaque(false);//lo hace invisible
			this.setContentAreaFilled(false);//elimina el contenido
			this.setBounds(300, 300, anchura, altura);// posicion y tamano del boton
//			botonImagen= createImageIcon();// se le asigna un archivo con el metodo createImageIcon
//			this.setIcon(new ImageIcon(botonImagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
			//se le asigna la imagen al boton y la imagen se escala al tamano del boton
		
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
		public void settearImagen (String nombreImagen) {
			botonImagen=createImageIcon(nombreImagen);
			this.setIcon(new ImageIcon(botonImagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));

		}
		public void escuchador (String Imagen1, String Imagen2) {
			this.addMouseListener(new MouseListener() {

				public void mouseEntered(MouseEvent e) {
					
					settearImagen(Imagen1);
					sonido.reproducirSonido();
					sonido.ajustarVolumen(-17.0f);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					sonido2.reproducirSonido();
					sonido2.ajustarVolumen(-17.0f);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					settearImagen(Imagen2);
					sonido.pararSonido();

					
				}
			});
		}
		
	
}
