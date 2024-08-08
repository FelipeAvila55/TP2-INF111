package Blocnotes;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class PetiteFenetre extends JDialog {

    private JLabel find;
    private JLabel replace;
    private JTextField inputFind;
    private JTextField inputReplace;
    private JRadioButton forward;
    private JRadioButton backward;
    private JRadioButton scopeAll;
    private JRadioButton scopeSelected;

    public PetiteFenetre(JFrame parent) {



        super(parent, "Panneau de recherche", true);
        initComposants();
        setSize(600, 400); // Adjusted size for better display
        setLocationRelativeTo(parent);
    }




    public void initComposants() {

 


        //Panneau Parent:
        JPanel mainPanel = new JPanel(); 
        mainPanel.setLayout(new GridLayout(4,1));
        add(mainPanel);



        //Panneau des labels et inputs:
        JPanel findReplacePanel = new JPanel();
        findReplacePanel.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns, 5px padding

        findReplacePanel.add(new JLabel ("Find:"));
        findReplacePanel.add(new JTextField());
        findReplacePanel.add(new JLabel ("Replace with:"));
        findReplacePanel.add(new JTextField());

        mainPanel.add(findReplacePanel, BorderLayout.NORTH);




        //Panneau de directions:
        JPanel directions= new JPanel();
        directions.setLayout(new GridLayout(2,1));
        directions.setBorder(BorderFactory.createTitledBorder("Directions"));
directions.add(new JRadioButton ("forward", true));
        directions.add(new JRadioButton ("backward"));
        mainPanel.add(directions);



        //Panneau d'Options:
        JPanel options= new JPanel();
        options.setLayout(new GridLayout(2,2));

        options.setBorder(BorderFactory.createTitledBorder("Options"));

        options.add(new JCheckBox("Case sensitive"));


        mainPanel.add(options);



        JPanel conteneurBtn= new JPanel();
        conteneurBtn.setLayout(new GridLayout(3,3));
        mainPanel.add(conteneurBtn);


        JPanel premiereLigne= new JPanel();
        premiereLigne.setLayout(new BoxLayout(premiereLigne, BoxLayout.X_AXIS));

        premiereLigne.add(new JButton("Find"));
        premiereLigne.add(new JButton("Select All"));
        premiereLigne.add(new JButton ("Close"));

        conteneurBtn.add(premiereLigne);

        JPanel deuxiemeLigne = new JPanel();
        deuxiemeLigne.setLayout(new BoxLayout(deuxiemeLigne, BoxLayout.X_AXIS));

 
    }
}