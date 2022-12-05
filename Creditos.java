import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Creditos extends JPanel{

	private JPanel panelBoton;
	//private JButton boton;
	//private ImageIcon botonImagen;
	
	public Creditos() {
		CrearBoton boton1 = new CrearBoton(200,50);
		
		setLayout(new BorderLayout());
		
		panelBoton = new JPanel();
		panelBoton.setBackground(Color.decode("#ABDDED"));

		
		panelBoton.setLayout(null);
		
		panelBoton.add(boton1);
	
		crearFondo();
		boton1.setLocation(720, 650);
		boton1.settearImagen("salir_off.png");
		boton1.escuchador("salir_on.png","salir_off.png");
		

//		boton1.addMouseListener(new MouseListener() {
//
//			public void mouseEntered(MouseEvent e) {
//				
//				boton1.settearImagen("boton 4.png");
//				panelBoton.revalidate();
//				panelBoton.repaint();
//				
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				boton1.settearImagen("boton 3.png");
//				panelBoton.revalidate();
//				panelBoton.repaint();
//
//				
//			}
//		});
		agregarAccion(boton1);
		add(panelBoton);
	}
	
	void agregarAccion(final JButton boton) {
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
            	
            	panelBoton.removeAll();
            	add(new MenuPrincipal(1));
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
		imagen = createImageIcon("panel1.png");
		
		JLabel fondo = new JLabel(imagen);
		
		fondo.setBounds(0, 0, imagen.getIconWidth(), imagen.getIconHeight()); //260, 220
		
		panelBoton.add(fondo);
	}
//	public JButton crearBoton() {
//		boton= new JButton();//crea boton
//		boton.setBorderPainted(false);//elimina el borde
//		boton.setOpaque(false);//lo hace invisible
//		boton.setContentAreaFilled(false);//elimina el contenido
//		
//		
//
//		boton.setBounds(650, 650, 200, 50);// posicion y tamano del boton
//		
//		botonImagen= createImageIcon("boton 3.png");// se le asigna un archivo con el metodo createImageIcon
//		boton.setIcon(new ImageIcon(botonImagen.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH)));
//		//se le asigna la imagen al boton y la imagen se escala al tamano del boton
//	
//		
//		
//		
//		agregarAccion(boton);
//	
//		return boton;
//	}
	
}

