package Blocnotes;



import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;






/**
 * Classe JTextPaneYZ
 *
 * Cette classe représente une fenêtre de rédaction qui implémente les méthodes
 * d'annulation de saisi de texte "Undo" et "Redo" à l'appui des commande Ctrl+Z
 * et Ctrl+Y respectivement.
 * 
 * @version été 2024
 *
 * @authors : Felipe Avila Munoz, Rick Farrel, Monessa Pierre et Sonia Shair
 *          Zaie
 *
 */

public class JTextPaneCtrlYZ extends JTextPane {


	//déclaration des attributs:
	protected UndoManager undoManager;
	private InputMap inputMap;
	private ActionMap actionMap;




	/**
	 * Constructeur de JTextPaneCtrlYZ
	 *
	 * Initialise le JTextPane avec un gestionnaire d'annulation (UndoManager) et
	 * configure les raccourcis clavier pour les actions "Undo" et "Redo".
	 */


	
	 /*
	  * Constructeur par de défaut de JText
	  */
	public JTextPaneCtrlYZ() {

		super();
		undoManager = new UndoManager();
		actionListeners();

	}

	
	
	
	/**
	 * Sous-programme qui contient toutes les méthodes d'annulation 
	 * et de rétablissement de texte et de 
	 */
	private void actionListeners() {
	
		

		/**
		 * Méthode pour ajouter un UndoableEditListener pour suivre les modifications et
		 * les enregistrer dans l'UndoManager
		 */
		getDocument().addUndoableEditListener(new UndoableEditListener() {
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
			}
		});

		

		
		// Pour configurer les raccourcis clavier "Undo" (Ctrl+Z) et "Redo" (Ctrl+Y)
		inputMap = this.getInputMap(JTextPane.WHEN_FOCUSED);
		actionMap = this.getActionMap();

		
		

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK), "Undo");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK), "Redo");

		
		
		
		/**
         * Méthode qui associe l'action "Redo" au raccourci clavier Ctrl+Y.
         * Cette action sera exécutée lorsque l'utilisateur apuiera sur Ctrl+Y.
         */
		actionMap.put("Undo", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {
				if (undoManager.canUndo())
					undoManager.undo();
			}

		});

		
		/**
         * Méthode qui associe l'action "Redo" au raccourci clavier Ctrl+Y.
         * Cette action sera exécutée lorsque l'utilisateur apuiera sur Ctrl+Y.
         */
		actionMap.put("Redo", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				if (undoManager.canRedo())
					undoManager.redo();
					
			}
		});
		
		

	}

}
