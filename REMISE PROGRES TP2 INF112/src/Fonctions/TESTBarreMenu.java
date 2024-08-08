package Fonctions;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Fonctions.*;

public class TESTBarreMenu extends JMenuBar implements ActionListener {

	private JMenu menuFile, menuAffichage;
	JMenuItem iNouveau, iOuvrir, iSauvegarder, iEnregistrer_sous, iQuitter, iAgrandir, iDiminuer, imenuBarreDetat;
	private TESTCadreGUI cadreGUI;

	/**
	 * Constructeur de la barre de menu
	 */
	public TESTBarreMenu(TESTCadreGUI cadreGUI) {

		this.cadreGUI = cadreGUI;
		creerMenuBar();
		creerFileMenu();
		creerAffichageMenu();
	}

	/*
	 * Méthode pour créer la barre de menu en haut du Cadre GUI
	 */
	private void creerMenuBar() {

		menuFile = new JMenu("File");
		menuAffichage = new JMenu("Affichage");
		add(menuFile);
		add(menuAffichage);

	}

	/*
	 * Méthode pour ajouter des options au boutton de "File"
	 */
	public void creerFileMenu() {

		iNouveau = new JMenuItem("Nouveau");
		iNouveau.addActionListener(this);
		iNouveau.setActionCommand("Nouveau");

		iOuvrir = new JMenuItem("Ouvrir");
		iOuvrir.addActionListener(this);
		iOuvrir.setActionCommand("Ouvrir");

		iSauvegarder = new JMenuItem("Sauvegarder");
		iSauvegarder.addActionListener(this);
		iSauvegarder.setActionCommand("Sauvegarder");

		iEnregistrer_sous = new JMenuItem("Enregistrer_sous");

		iQuitter = new JMenuItem("Quitter");
		iQuitter.addActionListener(this);
		iQuitter.setActionCommand("Quitter");

		menuFile.add(iNouveau);
		menuFile.add(iOuvrir);
		menuFile.add(iSauvegarder);
		menuFile.add(iEnregistrer_sous);
		menuFile.add(iQuitter);

	}

	public void creerAffichageMenu() {

		iAgrandir = new JMenuItem("Agrandir");
		iAgrandir.addActionListener(this);
		iAgrandir.setActionCommand("Agrandir");

		iDiminuer = new JMenuItem("Diminuer");
		iDiminuer.addActionListener(this);
		iDiminuer.setActionCommand("Diminuer");
		
		imenuBarreDetat = new JMenuItem("Barre d'état");
		imenuBarreDetat.addActionListener(this);
		imenuBarreDetat.setActionCommand("Barre d'état");
		
		menuAffichage.add(iAgrandir);
		menuAffichage.add(iDiminuer);
		menuAffichage.add(imenuBarreDetat);

	}

	/**
	 * Ajoute un écouteur à l'option de la barre de menu pour effectuer une action
	 * 
	 * @param itemMenu, l'option pour créer un nouveau fichier
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		String bouttonClique = e.getActionCommand();

		switch (bouttonClique) {

		case "Nouveau":
			cadreGUI.getPanneauEditer().NouveauFichier(cadreGUI);
			break;
		case "Ouvrir":
			cadreGUI.getPanneauEditer().ouvrirFichier(cadreGUI);
			break;
		case "Sauvegarder":
			cadreGUI.getPanneauEditer().sauvegarderFichier(cadreGUI);
			break;
		case "Quitter":
			cadreGUI.getPanneauEditer().quitterApplication();
			break;
			
			
			
		case "Agrandir":
			cadreGUI.getPanneauEditer().agrandirTexte();
			break;
		case "Diminuer":
			cadreGUI.getPanneauEditer().diminuerTexte();

		}

	}

}
