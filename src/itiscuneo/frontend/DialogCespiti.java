package itiscuneo.frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogCespiti extends JDialog implements ActionListener {
    private FrameCespiti frameCespiti;
    private JTextField txtFieldCodice;
    private JTextField txtFieldQuantita;
    private JTextField txtFieldDataAcquisto;
    private JButton btnOk;
    private JButton btnUndo;

    public DialogCespiti(FrameCespiti frameCespiti) {
        this.frameCespiti = frameCespiti;
        initComponents();
        this.pack();
    }

    private void initComponents() {
        this.setLayout(new GridLayout(4, 2));

        this.add(new JLabel("Codice: "));
        txtFieldCodice = new JTextField(10);
        this.add(txtFieldCodice);

        this.add(new JLabel("Quantità: "));
        txtFieldQuantita = new JTextField(10);
        this.add(txtFieldQuantita);

        this.add(new JLabel("Data Acquisto: "));
        txtFieldDataAcquisto = new JTextField(10);
        this.add(txtFieldDataAcquisto);

        btnOk = new JButton("OK");
        this.add(btnOk);

        btnUndo = new JButton("Undo");
        this.add(btnUndo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
