package itiscuneo.frontend;
import itiscuneo.backend.CespitiFile;
import itiscuneo.backend.ElencoCespiti;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCespiti extends JFrame implements ActionListener {
    private ElencoCespiti elencoCespiti;
    private JButton btnNuovo;
    private DefaultTableModel dmtCespiti;
    private JTable tableCespiti;
    private JMenuItem menuItemCSV;
    private JMenuItem menuItemJson;

    public FrameCespiti(){
        super("Gestione cespiti");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.elencoCespiti = new ElencoCespiti();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        JPanel panelTable = new JPanel();

        String[] aHeaderTableCespiti = {"Codice", "Quantità", "Data acquisto"};
        dmtCespiti = new DefaultTableModel(aHeaderTableCespiti, 0);
        tableCespiti = new JTable(dmtCespiti);
        panelTable.add(new JScrollPane(tableCespiti));

        JPanel panelCmd = new JPanel();

        btnNuovo = new JButton("Nuovo");
        btnNuovo.addActionListener(this);
        panelCmd.add(btnNuovo);

        this.add(panelTable, BorderLayout.CENTER);
        this.add(panelCmd, BorderLayout.EAST);

        JMenuBar menuBar = initMenu();
        this.setJMenuBar(menuBar);
    }

    private JMenuBar initMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuItemJson = new JMenuItem("Esporta Json");
        menuItemCSV = new JMenuItem("Esporta CSV");
        menuFile.add(menuItemJson);
        menuFile.add(menuItemCSV);
        menuItemCSV.addActionListener(this);
        menuItemJson.addActionListener(this);

        return menuBar;
    }

    public ElencoCespiti getElencoCespiti() {
        return elencoCespiti;
    }

    public static void main(String[] args) {
        FrameCespiti frameCespiti = new FrameCespiti();
        frameCespiti.setVisible(true);
        frameCespiti.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNuovo){
            new DialogCespiti(this).setVisible(true);
        }
        if(e.getSource() == menuItemJson){

        }
        if(e.getSource() == menuItemCSV){
            CespitiFile cespitiFile = new CespitiFile();
            cespitiFile.scriviCSV(this.elencoCespiti);
        }
    }
}
