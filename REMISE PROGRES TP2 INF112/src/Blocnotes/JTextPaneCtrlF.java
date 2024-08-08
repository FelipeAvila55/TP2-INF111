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

    private InputMap inputMap;
    private ActionMap actionMap;

    /**
     * Constructeur de JTextPaneCtrlF
     *
     * Initialise le JTextPane et configure le raccourci clavier pour l'action de
     * recherche avec Ctrl+F.
     */
    public JTextPaneCtrlF() {
        super();
        configureKeyBindings();
    }

    /**
     * Configure les raccourcis clavier pour l'action de recherche (Ctrl+F)
     */
    private void configureKeyBindings() {
        inputMap = this.getInputMap(JTextPane.WHEN_FOCUSED);
        actionMap = this.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), "Find");

        actionMap.put("Find", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFindDialog();
            }
        });
    }

    /**
     * Affiche un JDialog de la classe PetiteFenetre pour la recherche
     */
    protected void showFindDialog() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        PetiteFenetre findDialog = new PetiteFenetre(parentFrame);
        findDialog.setVisible(true);
    }
}
