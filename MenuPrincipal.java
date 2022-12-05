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
	private Sound2 sonidoFondo;
	private JPanel panelBotones;
	private CrearBoton titulo;
	private CrearBoton botones[];
	private int contador;
	boolean si=false;
	private final int puntos[] = {0, 0};
	
	public MenuPrincipal(int contador) {
		
		this.contador=contador;
		if (contador==0) {
			
			sonidoFondo= new Sound2("musicafondo");
			sonidoFondo.ajustarVolumen(-35.0f);
			sonidoFondo.repetirSonido();
		}
		setLayout(new BorderLayout());
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.decode("#ABDDED"));
		titulo= new CrearBoton(522,78);
		titulo.settearImagen("titulo.png");
		titulo.setBounds(235, 100, 522, 78);
		panelBotones.add(titulo);
		botones = new CrearBoton[4];
		panelBotones.setLayout(null);
		
		for(int i=0; i<4; i++) {
			botones[i]=new CrearBoton(200,50);
		}
//		botones[0] = new CrearBoton(200,50);
//		botones[1] = new CrearBoton(200,50);
//		botones[2] = new CrearBoton(200,50);
//		botones[3] = new CrearBoton(200,50);
		//crea los 4 botones
		
		for (int i = 0; i < 4; i++) {
			
			botones[i].setBounds(400, ((i+2)*125), 200, 50);//insertas la posicion y medidas de los botones
			
			panelBotones.add(botones[i]);//agrega los botones al panel
			
			agregarAccion(botones[i], i);
		}
		botones[0].settearImagen("jugar_off.png");
		botones[0].escuchador("jugar_on.png", "jugar_off.png");
		botones[1].settearImagen("comojugar_off.png");
		botones[1].escuchador("comojugar_on.png", "comojugar_off.png");
		botones[2].settearImagen("creditos_off.png");
		botones[2].escuchador("creditos_on.png", "creditos_off.png");
		botones[3].settearImagen("salir_off.png");
		botones[3].escuchador("salir_on.png", "salir_off.png");

		
		//crearFondo();
		
		add(panelBotones);//agrega el panel
	}
	
	void agregarAccion(final JButton boton, final int x) {
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
            	
            	switch(x)
            	{
            	case 0:
            		if (contador==0) {
            			
            			sonidoFondo.pararSonido();
            		}
            		panelBotones.removeAll();
            		add(new Desarrollo(puntos));   
            		panelBotones.revalidate();
            		break;
            	case 1://crea y muestra Como jugar
            		panelBotones.removeAll();
            		add(new ComoJugar());   
            		panelBotones.revalidate();
            		break;
            	case 2:
            		panelBotones.removeAll();
            		add(new Creditos());   
            		panelBotones.revalidate();
            		break;
            	case 3://termina el programa
            		System.exit(0);
            		break;
            	}
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
