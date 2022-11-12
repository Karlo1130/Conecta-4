import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Creditos extends JPanel{

	private JPanel panelBoton;
	private JButton boton;
	
	public Creditos() {
		
		setLayout(new BorderLayout());
		
		panelBoton = new JPanel();
		
		panelBoton.setLayout(null);
		
		boton = new JButton("REGRESAR");
		
		panelBoton.add(boton);//Agrega el objeto dentro del panel
		boton.setBounds(600, 600, 200, 100);
		boton.setBackground(Color.BLUE);//color de fondo
		boton.setForeground(Color.WHITE);//color del texto			
		boton.setFont(new Font(boton.getFont().getFontName(), Font.BOLD, 18));
		panelBoton.add(boton);
			
		agregarAccion(boton);
		
		crearFondo();
		
		add(panelBoton);
		
	}
	
	void agregarAccion(final JButton boton) {
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
            	
            	panelBoton.removeAll();
            	add(new MenuPrincipal());
        		panelBoton.revalidate();;
        		
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
            return new ImageIcon(getClass().getResource("img/kuriboh.jpg"));
        }
    }
	
	void crearFondo() {
		Icon imagen;
		imagen = createImageIcon("kuriboh.jpg");
		
		JLabel fondo = new JLabel(imagen);
		
		fondo.setBounds(0, 0, 480, 360); //260, 220
		
		panelBoton.add(fondo);
	}
	
}
