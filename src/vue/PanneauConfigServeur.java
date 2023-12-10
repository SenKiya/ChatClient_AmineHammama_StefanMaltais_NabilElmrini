package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adr, int port) {
        //à compléter
        txtAdrServeur = new JTextField("127.0.0.1");
        JLabel ip = new JLabel("Adresse IP : ");
        txtNumPort = new JTextField(Integer.toString(port));
        JLabel place = new JLabel("Port : ");
        setLayout(new GridLayout(2, 2));
        add(ip);
        add(txtAdrServeur);
        add(place);
        add(txtNumPort);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
