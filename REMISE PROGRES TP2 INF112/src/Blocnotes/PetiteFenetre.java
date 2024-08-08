package Blocnotes;

import javax.swing.*;
import java.awt.*;

/**
 * Classe représentant une petite fenêtre de dialogue pour la recherche et le remplacement de texte.
 *
 * @version été 2024
 * @authors
 *  Felipe Avila Munoz,
 *  Rick Farrel,
 *  Monessa Pierre,
 *  Sonia Shair Zaie
 */
public class PetiteFenetre extends JDialog {

    // Déclaration des attributs:
    private JLabel find;
    private JLabel replace;
    private JTextField inputFind;
    private JTextField inputReplace;
    private JRadioButton forward;
    private JRadioButton backward;
    private JRadioButton scopeAll;
    private JRadioButton scopeSelected;
    private JCheckBox caseSensitive;
    private JButton btnFind;
    private JButton btnSelectAll;
    private JButton btnClose;
    private JButton btnReplace;
    private JButton btnReplaceAll;

    /**
     * Constructeur par défaut de PetiteFenetre
     *
     * @param parent Le JFrame parent qui sera bloqué par ce dialogue modal.
     */
    public PetiteFenetre(JFrame parent) {
        // Appel du constructeur de JDialog avec modalité
        super(parent, "Panneau de recherche", true);
        initComposants();
        // Définir la taille du dialogue
        setSize(600, 400);
        // Centrer le dialogue par rapport à sa fenêtre parent
        setLocationRelativeTo(parent);
    }

    /**
     * Initialisation des composants de l'interface utilisateur
     */
    public void initComposants() {
        // Create the main panel and add it
        JPanel mainPanel = createMainPanel();
        add(mainPanel);

        // Add components to the main panel
        mainPanel.add(createFindReplacePanel());
        mainPanel.add(createDirectionPanel());
        mainPanel.add(createOptionsPanel());
        mainPanel.add(createButtonPanel());
    }

    // Method to create the main panel
    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        return mainPanel;
    }

    // Method to create the find/replace panel
    private JPanel createFindReplacePanel() {
        creerLabelFind();
        creerInputFind();
        creerLabelReplace();
        creerInputReplace();

        JPanel findReplacePanel = new JPanel();
        findReplacePanel.setLayout(new GridLayout(2, 2));
        findReplacePanel.add(find);
        findReplacePanel.add(inputFind);
        findReplacePanel.add(replace);
        findReplacePanel.add(inputReplace);

        return findReplacePanel;
    }

    // Method to create the direction panel
    private JPanel createDirectionPanel() {
        creerForward();
        creerBackward();

        JPanel directions = new JPanel();
        directions.setLayout(new GridLayout(2, 1));
        directions.setBorder(BorderFactory.createTitledBorder("Directions"));

        // Group the radio buttons
        ButtonGroup directionGroup = new ButtonGroup();
        directionGroup.add(forward);
        directionGroup.add(backward);

        // Add radio buttons to the panel
        directions.add(forward);
        directions.add(backward);

        return directions;
    }

    // Method to create the options panel
    private JPanel createOptionsPanel() {
        creerCaseSensitive();

        JPanel options = new JPanel();
        options.setLayout(new GridLayout(2, 2));
        options.setBorder(BorderFactory.createTitledBorder("Options"));
        options.add(caseSensitive);

        return options;
    }

    // Method to create the button panel
    private JPanel createButtonPanel() {
        creerBtnFind();
        creerBtnSelectAll();
        creerBtnClose();
        creerBtnReplace();
        creerBtnReplaceAll();

        JPanel conteneurBtn = new JPanel();
        conteneurBtn.setLayout(new GridLayout(3, 3));

        JPanel premiereLigne = new JPanel();
        premiereLigne.setLayout(new BoxLayout(premiereLigne, BoxLayout.X_AXIS));
        premiereLigne.add(btnFind);
        premiereLigne.add(btnSelectAll);
        premiereLigne.add(btnClose);
        conteneurBtn.add(premiereLigne);

        JPanel deuxiemeLigne = new JPanel();
        deuxiemeLigne.setLayout(new BoxLayout(deuxiemeLigne, BoxLayout.X_AXIS));
        deuxiemeLigne.add(btnReplace);
        deuxiemeLigne.add(btnReplaceAll);
        conteneurBtn.add(deuxiemeLigne);

        return conteneurBtn;
    }

    // Method to create the label for find
    private void creerLabelFind() {
        find = new JLabel("Find:");
    }

    // Method to create the input for find
    private void creerInputFind() {
        inputFind = new JTextField();
    }

    // Method to create the label for replace
    private void creerLabelReplace() {
        replace = new JLabel("Replace with:");
    }

    // Method to create the input for replace
    private void creerInputReplace() {
        inputReplace = new JTextField();
    }

    // Method to create the JRadioButton for forward
    private void creerForward() {
        forward = new JRadioButton("Forward", true);
    }

    // Method to create the JRadioButton for backward
    private void creerBackward() {
        backward = new JRadioButton("Backward");
    }

    // Method to create the JCheckBox for case sensitivity
    private void creerCaseSensitive() {
        caseSensitive = new JCheckBox("Case sensitive");
    }

    // Method to create the button for find
    private void creerBtnFind() {
        btnFind = new JButton("Find");
    }

    // Method to create the button for select all
    private void creerBtnSelectAll() {
        btnSelectAll = new JButton("Select All");
    }

    // Method to create the button for close
    private void creerBtnClose() {
        btnClose = new JButton("Close");
    }

    // Method to create the button for replace
    private void creerBtnReplace() {
        btnReplace = new JButton("Replace");
    }

    // Method to create the button for replace all
    private void creerBtnReplaceAll() {
        btnReplaceAll = new JButton("Replace All");
    }
}
