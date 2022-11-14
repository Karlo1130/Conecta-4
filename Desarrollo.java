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
import javax.swing.JPanel;


public class Desarrollo extends JPanel{
	private JPanel panelBotones;
    private JButton botones[][];
    private JButton botonIndicaTurno;
    private String fichas[] = {"Azul.gif", "Rojo.gif"};
    Lista lista = new Lista(6, 7);

    int i, j, turno;
    String nombre[] = {"AZUL", "ROJO"};//guarda el nombre de la ficha, para el cambio de turno.
    String color = nombre[0];
    int cambiarColor = 0;

    public Desarrollo() {
        /*Crea el contenedor y lo divide en 5 zonas NORTH, SOUTH, EAST, WEST y CENTER*/
        setLayout(new BorderLayout());

        botonIndicaTurno = new JButton("Turno de: " + color);
        add(botonIndicaTurno, BorderLayout.NORTH);//Agrega el objeto dentro del panel
        botonIndicaTurno.setBackground(Color.blue);//color de fondo
        botonIndicaTurno.setForeground(Color.white);//color del texto
        botonIndicaTurno.setFont(new Font(botonIndicaTurno.getFont().getFontName(), Font.BOLD, 18));

        /*Crear el panel para manejar el tablero de fichas*/
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.black);//color de fondo

        /*Crear la matriz de botones*/
        botones = new JButton[6][7];
        panelBotones.setLayout(new GridLayout(6, 7, 0, 0));

        /*Crear y agregar botones*/
        Icon imagen;//objeto para crear la imagen

        for (i = 0; i < 6; i++) {//renglon
            for (j = 0; j < 7; j++) //columna
            {
                /*selecciona el nombre de la imagen que esta en la 1er posicion del arreglo 
                 * y lo crea a Icon*/
            	imagen = createImageIcon(fichas[0]);
                /*crear el boton en la posicion i-j de la matriz*/
                botones[i][j] = new JButton();
                /*tomar las dimensiones de la imagen del icono*/
                Dimension tamanoFigura = new Dimension(imagen.getIconHeight(), imagen.getIconWidth());
                /* hacer el boton del tama�o de la imagen del icono*/
                botones[i][j].setPreferredSize(tamanoFigura);
                /*agregar al boton el evento del click del mouse*/
                agregarAccion(botones[i][j], i, j);
                /*agregar la matriz de botones al panel para ser visualizado en la ventana*/
                panelBotones.add(botones[i][j]);
            }
        }
        /*agregar el panel de la matriz de botones al panel principal.*/
        add(panelBotones, BorderLayout.CENTER);
        lista.CrearLista();//Crear lista con el dato igual a Cero.
        turno = 1;//turno ficha azul
    }

    /*METODO QUE AL HACER CLICK SOBRE ALGUN BOTON DE LA MATRIZ, VERIFICA CON LAS 
     * COORDENADAS (x,y) QUE BOTON FUE PRESIONADO Y REALIZA LAS VALIDACIONES 
	 * Y CAMBIO DE TURNO CORRESPONDIENTE*/
    void agregarAccion(final JButton boton, final int x, final int y) {
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                int x1 = lista.moverficha(turno, y);
                if (x1 > -1) {//si renglon esta disponible
                    botones[x1][y].setIcon(createImageIcon(fichas[turno - 1]));
                    lista.desplegarLista();
                    
                    if(lista.verificarLleno()) {
                    	removeAll();
                    	add(new MenuPrincipal());
                		panelBotones.revalidate();;
                    }
                    
                    if(lista.verificarGanador()) {
                    	removeAll();
                    	add(new ComoJugar());
                		panelBotones.revalidate();;
                    }
                    
                    CambiarTurno();
                }
            }
        });
    }

    void CambiarTurno(){
        if(turno == 1){
            turno = 2;
            color = nombre[1];
        }else{
            turno = 1;
            color = nombre[0];
        }
        //actualiza el texto del boton que indica el turno del jugador actual.
        botonIndicaTurno.setText("Turno de: " + color);
        cambiarColor();
    }

    /*Metodo que busca una imagen segun su nombre en la ruta actual y 
     * crea un objeto de imagen*/
    protected ImageIcon createImageIcon(String nombreFigura){
        java.net.URL imgURL = getClass().getResource("img/" + nombreFigura);
        /*si encuentra en la carpeta la imagen indicada*/
        if(imgURL != null){
            return new ImageIcon(imgURL);
        }else{
            /*Devuelve por default la imagen de ficha azul*/
            return new ImageIcon(getClass().getResource("img/Azul.gif"));
        }
    }
    
    void cambiarColor() {
    	switch(cambiarColor)
        {
        case 0:
        	botonIndicaTurno.setBackground(Color.red);
        	cambiarColor++;
        	break;
        case 1:
        	botonIndicaTurno.setBackground(Color.blue);
        	cambiarColor--;
        	break;
        } 	
    }
}//Fin Desarrollo
