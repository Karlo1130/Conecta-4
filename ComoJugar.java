import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComoJugar extends JPanel{

	private JPanel panelBotones;
	private JButton boton;
	
	int menu = 1;
	
	public ComoJugar() {
		
		setLayout(new BorderLayout());
		
		panelBotones = new JPanel();
        //panelBotones.setBackground(Color.black);//color de fondo
		
		panelBotones.setLayout(null);
		
		boton = new JButton("REGRESAR");
		
		
		add(boton/*, BorderLayout.CENTER*/);//Agrega el objeto dentro del panel
		boton.setBounds(600, 600, 200, 100);
		boton.setBackground(Color.BLUE);//color de fondo
		boton.setForeground(Color.WHITE);//color del texto			
		boton.setFont(new Font(boton.getFont().getFontName(), Font.BOLD, 18));
		panelBotones.add(boton);
			
		agregarAccion(boton);
		
		crearFondo();
		
		add(panelBotones/*, BorderLayout.CENTER*/);
		
	}
	
	void agregarAccion(final JButton boton) {
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
            	
            	menu=-1;
            	System.out.println(menu);
            	
            }
        });
    }
	
	protected ImageIcon createImageIcon(String nombreFigura){
        java.net.URL imgURL = getClass().getResource("img/" + nombreFigura);
        /*si encuentra en la carpeta la imagen indicada*/
        if(imgURL != null){
            return new ImageIcon(imgURL);
        }else{
            /*Devuelve por default la imagen de ficha azul*/
            return new ImageIcon(getClass().getResource("img/mamada.jpg"));
        }
    }
	
	void crearFondo() {
		Icon imagen;
		imagen = createImageIcon("mamada.jpg");
		
		JLabel fondo = new JLabel(imagen);
		
		fondo.setBounds(0, 0, 480, 360); //260, 220
		
		panelBotones.add(fondo);
	}
	
}
