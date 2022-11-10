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

public class MenuPrincipal extends JPanel{

	private JPanel panelBotones;
	private JButton botones[];
	
	private int i;
	
	int menu=-1;
	
	public MenuPrincipal() {
		
		setLayout(new BorderLayout());
		
		panelBotones = new JPanel();
        //panelBotones.setBackground(Color.black);//color de fondo
		
		botones = new JButton[4];
		panelBotones.setLayout(null);
		
		botones[0] = new JButton("JUGAR");//crea los 4 botones
		botones[1] = new JButton("COMO JUGAR");
		botones[2] = new JButton("CREDITOS");
		botones[3] = new JButton("SALIR");
		
		for (i = 0; i < 4; i++) {
			add(botones[i]/*, BorderLayout.CENTER*/);//Agrega el objeto dentro del panel
			botones[i].setBounds(400, ((i+1)*150), 200, 100);
			botones[i].setBackground(Color.BLUE);//color de fondo
			botones[i].setForeground(Color.WHITE);//color del texto
			botones[i].setFont(new Font(botones[i].getFont().getFontName(), Font.BOLD, 18));
			panelBotones.add(botones[i]);
			
			agregarAccion(botones[i], i);
		}
		
		crearFondo();
		
		add(panelBotones/*, BorderLayout.CENTER*/);
	}
	
	void agregarAccion(final JButton boton, final int x) {
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
            	menu = x; //iguala menu a la opcion elegida	
            	System.out.println(menu);
            		
            	if (menu == 3)
            		System.exit(x);
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
