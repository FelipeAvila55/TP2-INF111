package Fonctions;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import GUI.*;

/**
 * Classe CadreGUI
 *
 * Cette classe représente la fenêtre principale de l'application Swing. Elle
 * initialise et affiche l'interface utilisateur.
 *
 * @version été 2024
 *
 * @authors : Felipe Avila Munoz, Rick Farrel, Monessa Pierre et Sonia Shair
 *          Zaie
 *
 */

public class TESTCadreGUI extends JFrame {

	
	private TESTPanneauEditer pEditer;
	
	/**
	 * Constructeur du CadreGUI qui initialise la barre de menu et affiche la fenêtre principale. 
	 * Elle crée un JFrame, configure ses propriétés et y ajoute le panneau éditeur de texte.
	 * 
	 * Stratégie : 
	 * - Configurer le JFrame pour maximiser la fenêtre et définir les actions de fermeture. 
	 * - Configurer le JFrame pour adapter l'affichage en fonction du texte tapé à l'écran
	 */
	

	public TESTCadreGUI() {

		TESTBarreMenu barreMenu = new TESTBarreMenu(this);
		this.setJMenuBar(barreMenu);
		creerCadreGUI();

	}
	
	private void creerCadreGUI(){
		
		pEditer = new TESTPanneauEditer();
		JScrollPane barresDefile = new JScrollPane(pEditer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barresDefile.setBorder(BorderFactory.createEmptyBorder());
		
		setTitle("Bloc-note");
		setContentPane(barresDefile);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	 public TESTPanneauEditer getPanneauEditer() {
	
		 return pEditer;
	 
	 }
	 
	
		
	 
	
	

}
