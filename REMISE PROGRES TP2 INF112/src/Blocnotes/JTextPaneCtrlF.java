package Blocnotes;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import Blocnotes.PetiteFenetre;





/**
 * Classe JTextPaneCtrlF
 *
 * Cette classe représente une fenêtre de rédaction qui implémente la méthode de
 * recherche de texte avec la commande Ctrl+F.
 * 
 * @version été 2024
 *
 * @authors : Felipe Avila Munoz, Rick Farrel, Monessa Pierre et Sonia Shair
 *          Zaie
 *
 */
public class JTextPaneCtrlF extends JTextPane {



    //déclaration des attributs:
    private InputMap inputMap;
    private ActionMap actionMap;





    /**
     * Constructeur par défaut de JTextPaneCtrlF
     *
     * Initialise le JTextPane et configure le raccourci clavier pour l'action de
     * recherche avec Ctrl+F.
     * 
     */
    public JTextPaneCtrlF() {

        super();
        configureKeyBindings();

    }







    /**
     * Configure les raccourcis clavier pour l'action de recherche (Ctrl+F)
     */
    private void configureKeyBindings() {





         // Récupère l'InputMap du JTextPane lorsqu'il est focalisé
        inputMap = this.getInputMap(JTextPane.WHEN_FOCUSED);


          // Récupère l'ActionMap du JTextPane
        actionMap = this.getActionMap();


    // Associe la touche Ctrl+F à l'identifiant "Find" dans l'InputMap
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), "Find");


        // Associe l'identifiant "Find" à une action spécifique dans l'ActionMap
        actionMap.put("Find", new AbstractAction() {


            @Override
            public void actionPerformed(ActionEvent e) {

            // Appelle une méthode (supposée existante) pour afficher un dialogue de recherche
            showFindDialog();

            }
        });
    }







    /**
     * Affiche un JDialog de la classe PetiteFenetre pour la recherche
     */
    protected void showFindDialog() {


        // Obtient la fenêtre parente de ce JTextPane. La méthode SwingUtilities.getWindowAncestor(this)
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);


        // Crée une instance de PetiteFenetre, qui est un JDialog personnalisé pour effectuer des recherches.
        PetiteFenetre findDialog = new PetiteFenetre(parentFrame);


        // Rend le JDialog visible. Lorsque setVisible(true) est appelé, le dialogue apparaît à l'écran.
        findDialog.setVisible(true);

    }
}
