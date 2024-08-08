package GUI;

import java.awt.FileDialog;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import Blocnotes.*;

/**
 * Classe PanneauEditer
 *
 * Cette classe représente la fenêtre de rédaction principale de l'application
 * Swing. Elle initialise et affiche l'interface utilisateur.
 *
 * @version été 2024
 *
 * @authors : Felipe Avila Munoz, Rick Farrel, Monessa Pierre et Sonia Shair
 *          Zaie
 *
 */

public class TESTPanneauEditer extends JTextPaneCtrlFYZ {

	private String nomFichier;
	private String adresseFichier;
	private int taillePolice = 12;
	private static JPanel panneauFind;
	
	/**
	 * Constructeur du Panneau de rédaction
	 */
	public TESTPanneauEditer() {
		super();

	}

	
	/**
	 * Methode servant à effacer tout le contenu d'un JTextPane
	 * pour représenter un nouveau fichier 
	 */
	public void NouveauFichier(JFrame parent) {
		this.setText("");
		parent.setTitle("Nouveau");
	}

	
	 /**
     * Méthode servant à ouvrir le contenu d'un fichier '.txt'
     */
    public void ouvrirFichier(JFrame parent) {
        FileDialog fd = new FileDialog(parent, "Ouvrir", FileDialog.LOAD);
        fd.setVisible(true);

        String nom = fd.getFile();
        String adresse = fd.getDirectory();
        
        if (nom != null && adresse != null) {
            String chemin = adresse + nom;
            try (BufferedReader reader = new BufferedReader(new FileReader(chemin))) {
                this.read(reader, null);
                nomFichier = nom;
                adresseFichier = adresse;
                parent.setTitle(nomFichier);
                resetUndoManager();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void resetUndoManager() {
        undoManager.discardAllEdits(); // Reset the undo manager
        getDocument().addUndoableEditListener(new UndoableEditListener() {
          
        	@Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }
    
	/**
     * Méthode servant à sauvegarder le contenu du JTextPane dans le fichier courant
     */
    public void sauvegarderFichier(JFrame parent) {
        if (nomFichier != null && adresseFichier != null) {
            // Sauvegarder dans le fichier existant
            String chemin = adresseFichier + nomFichier;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(chemin))) {
                this.write(writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
//        else {
//            // Appeler sauvegarderSousFichier si le fichier n'est pas défini
//            sauvegarderSousFichier(parent);
//        }
    }

  
	
//	 /**
//     * Méthode servant à sauvegarder-sous un nouveau fichier le contenu du JTextPane
//     */
//    public void sauvegarderSousFichier(JFrame parent) {
//        FileDialog fd = new FileDialog(parent, "Sauvegarder", FileDialog.SAVE);
//        fd.setVisible(true);
//
//        String chemin = fd.getDirectory() + fd.getFile();
//
//        if (chemin != null) {
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(chemin))) {
//                this.write(writer);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (fd.getFile() != null) {
//            nomFichier = fd.getFile();
//            adresseFichier = fd.getDirectory();
//            parent.setTitle(nomFichier);
//        }
//    }
	
    
    /**
     * Méthode pour quitter l'application
     */
    public void quitterApplication() {
        System.exit(0);
    }
    
    
    /**
     * Méthode qui agrandit la taille du texte dans le JTextPane
     */
    public void agrandirTexte() {
        taillePolice += 2;
        this.setFont(new Font("Arial", Font.PLAIN, taillePolice));
    }
    
    /**
     * Méthode qui diminue la taille du texte dans le JTextPane
     */
    public void diminuerTexte() {
        taillePolice -= 2;
        this.setFont(new Font("Arial", Font.PLAIN, taillePolice));
    }
    
    
    
    

}