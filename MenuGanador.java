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

public class MenuGanador extends JPanel{

	private JPanel panelBotones;
	private JLabel puntaje[];
	private JLabel mostrarGanador;
	private JButton botones[];
	
	private int[] puntos = new int[3];
	
	public MenuGanador(int turno, int[] puntos) {
		
		this.puntos = puntos;
		
		setLayout(new BorderLayout());
		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLACK);
		
		botones = new JButton[3];
		panelBotones.setLayout(null);
		
		botones[0] = new JButton("VOLVER A JUGAR");
		botones[1] = new JButton("SALIR AL MENU PRINCIPAL");
		botones[2] = new JButton("SALIR DEL JUEGO");
		//crea los 3 botones
		
		for (int i = 0; i < 3; i++) {
			botones[i].setBounds(400, ((i+1)*150), 200, 100);//insertas la posicion y medidas de los botones
			botones[i].setBackground(Color.BLUE);//color de fondo
			botones[i].setForeground(Color.WHITE);//color del texto
			botones[i].setFont(new Font(botones[i].getFont().getFontName(), Font.BOLD, 18));
			panelBotones.add(botones[i]);//agrega los botones al panel
			
			agregarAccion(botones[i], i);
		}
		
		puntaje = new JLabel[2];
		
		puntaje[0] = new JLabel("AZUL: "+puntos[0]);
		
		puntaje[0].setBounds(300, 25, 200, 100);
		puntaje[0].setBackground(Color.BLUE);
		puntaje[0].setForeground(Color.WHITE);//color del texto
		puntaje[0].setFont(new Font(puntaje[0].getFont().getFontName(), Font.BOLD, 18));
		puntaje[0].setOpaque(true);
		
		puntaje[1] = new JLabel("ROJO: "+puntos[1]);
		puntaje[1].setBounds(500, 25, 200, 100);
		puntaje[1].setBackground(Color.RED);
		puntaje[1].setForeground(Color.WHITE);//color del texto
		puntaje[1].setFont(new Font(puntaje[0].getFont().getFontName(), Font.BOLD, 18));
		puntaje[1].setOpaque(true);
		
		mostrarGanador = new JLabel();
		mostrarGanador.setBounds(25, 25, 200, 100);
		mostrarGanador.setFont(new Font(puntaje[0].getFont().getFontName(), Font.BOLD, 18));
		mostrarGanador.setForeground(Color.WHITE);//color del texto
		mostrarGanador.setOpaque(true);
		
		switch(turno)
		{
		case 0:
			mostrarGanador.setText("NINGUNO GANA");
			mostrarGanador.setBackground(Color.MAGENTA);
			break;
		case 1:
			mostrarGanador.setText("GANA EL AZUL");
			mostrarGanador.setBackground(Color.BLUE);
			break;
		case 2:
			mostrarGanador.setText("GANA EL ROJO");
			mostrarGanador.setBackground(Color.RED);
			break;
		}
		
		add(mostrarGanador);
		
		for (int i = 0; i < puntaje.length; i++) {
			add(puntaje[i]);
		}
		
		add(panelBotones);
	}
	
	void agregarAccion(final JButton boton, final int x) {
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
            	
            	switch(x)
            	{
            	case 0:
            		panelBotones.removeAll();
            		add(new Desarrollo(puntos));   
            		panelBotones.revalidate();
            		break;
            	case 1://crea y muestra Como jugar
            		panelBotones.removeAll();
            		add(new MenuPrincipal());
            		panelBotones.revalidate();
            		break;
            	case 2://termina el programa
            		System.exit(0);
            		break;
            	}
            }
        });
    }

	
	
}
