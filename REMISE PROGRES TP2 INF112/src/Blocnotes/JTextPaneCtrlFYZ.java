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

    private JTextPaneCtrlF findHelper;

    /**
     * Constructeur de JTextPaneCtrlFYZ
     *
     * Initialise le JTextPane avec un gestionnaire d'annulation (UndoManager) et
     * configure les raccourcis clavier pour les actions "Undo", "Redo" et "Find".
     */
    public JTextPaneCtrlFYZ() {
    	
        super();
        findHelper = new JTextPaneCtrlF();
        configureFindKeyBinding();
    }

    /**
     * Configure les raccourcis clavier pour l'action de recherche (Ctrl+F)
     */
    private void configureFindKeyBinding() {
        InputMap inputMap = this.getInputMap(JTextPane.WHEN_FOCUSED);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), "Find");

        actionMap.put("Find", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findHelper.showFindDialog();
            }
        });
    }
}
