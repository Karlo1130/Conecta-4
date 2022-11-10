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

public class Pantallas extends JPanel{

	private JPanel base;
	private MenuPrincipal principal;
	private ComoJugar tutorial;
	
	public Pantallas() {
		
		setLayout(new BorderLayout());
		
		base = new JPanel();
		
		base.setLayout(null);
		
		principal = new MenuPrincipal();
		tutorial = new ComoJugar();
	
		add(principal);
		
		
	}
	
}
