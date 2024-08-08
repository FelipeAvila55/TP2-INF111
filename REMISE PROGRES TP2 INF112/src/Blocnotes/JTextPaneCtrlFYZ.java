package Blocnotes;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;





/**
 * Classe JTextPaneCtrlFYZ
 *
 * Cette classe représente une fenêtre de rédaction qui implémente les méthodes
 * d'annulation de saisie de texte "Undo" et "Redo" à l'appui des commandes Ctrl+Z
 * et Ctrl+Y respectivement, ainsi que la recherche de texte avec la commande Ctrl+F.
 * 
 * @version été 2024
 *
 * authors : Felipe Avila Munoz, Rick Farrel, Monessa Pierre et Sonia Shair Zaie
 *
 */
public class JTextPaneCtrlFYZ extends JTextPaneCtrlYZ {



    
    //déclaration de l'attribut:
    private JTextPaneCtrlF findHelper;






    /**
     * Constructeur par défaut de JTextPaneCtrlFYZ
     *
     * Initialise le JTextPane avec un gestionnaire d'annulation (UndoManager) et
     * configure les raccourcis clavier pour les actions "Undo", "Redo" et "Find".
     */
    public JTextPaneCtrlFYZ() {
    	

    
        // Appel du constructeur de la superclasse (JTextPane) pour initialiser correctement le JTextPane.        
        super();


        // Crée une instance de JTextPaneCtrlF
        findHelper = new JTextPaneCtrlF();


      // Appelle une méthode définie ailleurs dans cette classe pour configurer le raccourci clavier pour la recherche.       
        configureFindKeyBinding();

    }






    /**
     * Configure les raccourcis clavier pour l'action de recherche (Ctrl+F)
     */
    private void configureFindKeyBinding() {


        // Accède à l'InputMap du JTextPane lorsque celui-ci est focalisé.
        InputMap inputMap = this.getInputMap(JTextPane.WHEN_FOCUSED);


        // Accède à l'ActionMap du JTextPane.
        ActionMap actionMap = this.getActionMap();


        // Associe la combinaison de touches Ctrl+F (KeyCode F avec le modificateur Ctrl enfoncé)
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), "Find");


        // Associe l'identifiant "Find" à une action spécifique dans l'ActionMap.
        actionMap.put("Find", new AbstractAction() {



            @Override
            public void actionPerformed(ActionEvent e) {


               // Cette méthode est appelée lorsque le raccourci Ctrl+F est utilisé.               
                findHelper.showFindDialog();

            }
        });
    }
}
